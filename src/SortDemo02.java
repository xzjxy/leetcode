import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortDemo02 {
    /**
     * 各种排序算法及性能分析
     */

    public static Random r = new Random();

//    public static void main(String[] args) {
//        int[] arr1 = {23, 40, 90, 41, 32, 23, 78};
//        int[] arr2 = generateRandomArray(3, 100);
//        int[] arr3 = new int[5];
//        int[] arr4 = {6};
//        int[] arr5 = {43, 66};
//        int[] arr6 = {6, 89, 42, 43, 66, 16};
//        int a = 1;
//    }

    // 归并排序，分成两部分，先给左边排好序，后给右边排好序，合并两边排序结果
    private static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = (l + r) / 2;
        int[] larr = arrBuild(arr, 0, mid);
//        System.out.println("Larr排序前："+Arrays.toString(larr));
        int[] rarr = arrBuild(arr, mid + 1, r);
        larr = copyArray(mergeSort(larr));
        rarr = copyArray(mergeSort(rarr));
        return merge(larr, rarr);
    }
    private static int[] merge(int[] larr, int[] rarr) {
        int[] res = new int[larr.length + rarr.length];
        int i = 0;
        int a = 0;
        int b = 0;
        while (a < larr.length && b < rarr.length) {
            res[i++] = larr[a] <= rarr[b] ? larr[a++] : rarr[b++];
        }
        while (a < larr.length) {
            res[i++] = larr[a++];
        }
        while (b < rarr.length) {
            res[i++] = rarr[b++];
        }
        return res;
    }

    private static int[] arrBuild(int[] arr, int begain, int end) {
        int[] res = new int[end - begain + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[begain + i];
        }
        return res;
    }


    /**
     * 交换数组中元素的值
     */
    public static void swap(int arr[], int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }




    /**
     * 对数器：用性能不好绝对正确的算法， 检测性能较好方法的正确性（随机生成检测样本）
     */
    @Test
    public void Test01() {
        int maxSize = 200;
        int maxValue = 1000;
        int testTime = 5000000;
        boolean succeed = true;
        int arr1[] = generateRandomArray(maxSize, maxValue);
        int arr2[] = copyArray(arr1);

        for (int i = 0; i <= testTime; i++) {
//            if (!isEqual(insertionSort(arr2), comparator(arr1))) { // 插入排序正确性测试
            if (!isEqual(mergeSort(arr2), comparator(arr1))) { // 归并排序正确性测试
                System.out.println("arr1" + Arrays.toString(arr1));
                System.out.println("arr2" + Arrays.toString(arr2));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fuck!");
    }

    public static boolean isEqual(int[] arr2, int[] arr1) {
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));

    }

    // 复制一个地址不同 内容相同的数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 官方排序方法
     */
    public static int[] comparator(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    /**
     * 随机生成测试数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int realSize = r.nextInt(maxSize + 1);
        int[] arr = new int[realSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(maxValue + 1);
        }
        return arr;
    }
}
