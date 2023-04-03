import bucketSort.BucketSortDemo;
import fastsort.FastSortAll;
import insertSort.InsertSort;
import mergeExtension.MyMergeSort;
import heapSort.HeapSortDemo01;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class TestALlSort {
    public static Random R = new Random();

    // 快排测试
    @Test
    public void testFastSort() {
        FastSortAll fs = new FastSortAll();
        int maxSize = 200;
        int maxValue = 1000;
        int testTime = 5000000;
        boolean succeed = true;
        int arr1[] = generateRandomArray(maxSize, maxValue);
        int arr2[] = copyArray(arr1);
        fs.fastSort01(arr2);
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            if (!isEqual(arr2, comparator(arr1))) {
                succeed = false;
                System.out.println("arr1" + Arrays.toString(arr1));
                System.out.println("arr2" + Arrays.toString(arr2));
                break;
            }
        }
        if (succeed) {
            Long endTime = System.currentTimeMillis();
            System.out.println("快速排序一共花费了：" + (endTime - startTime) / 1000 + "s");
        }
        System.out.println(succeed ? "Nice!" : "Fucking fuck!");
    }

    // 我的归并排序测试
    @Test
    public void testMymergeSort() {
        MyMergeSort mms = new MyMergeSort();
        int maxSize = 200;
        int maxValue = 1000;
        int testTime = 5000000;
        boolean succeed = true;
        int arr1[] = generateRandomArray(maxSize, maxValue);
        int arr2[] = copyArray(arr1);
        arr2 = mms.mergerSort(arr2);
//        System.out.println(Arrays.toString(arr2));

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            if (!isEqual(arr2, comparator(arr1))) {
                succeed = false;
                System.out.println("arr1" + Arrays.toString(arr1));
                System.out.println("arr2" + Arrays.toString(arr2));
                break;
            }
        }
        if (succeed) {
            Long endTime = System.currentTimeMillis();
            System.out.println("我的归并排序一共花费了：" + (endTime - startTime) / 1000 + "s");
        }

        System.out.println(succeed ? "Nice!" : "Fucking fuck!");
    }

    // 我的归并排序测试
    @Test
    public void testMergeSort() {
        MyMergeSort mms = new MyMergeSort();
        int maxSize = 200;
        int maxValue = 1000;
        int testTime = 5000000;
        boolean succeed = true;
        int arr1[] = generateRandomArray(maxSize, maxValue);
        int arr2[] = copyArray(arr1);
        arr2 = mms.mergerSort(arr2);
//        System.out.println(Arrays.toString(arr2));

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            if (!isEqual(arr2, comparator(arr1))) {
                succeed = false;
                System.out.println("arr1" + Arrays.toString(arr1));
                System.out.println("arr2" + Arrays.toString(arr2));
                break;
            }
        }
        if (succeed) {
            Long endTime = System.currentTimeMillis();
            System.out.println("官方归并排序一共花费了：" + (endTime - startTime) / 1000 + "s");
        }
        System.out.println(succeed ? "Nice!" : "Fucking fuck!");
    }

    // 插入排序测试
    @Test
    public void testInsertSort() {
        int maxSize = 200;
        int maxValue = 1000;
        int testTime = 5000000;
        boolean succeed = true;
        int arr1[] = generateRandomArray(maxSize, maxValue);
        int arr2[] = copyArray(arr1);
//        arr2 = InsertSort.insertSort01(arr2);
        BucketSortDemo.bucketSort(arr2);
//        System.out.println(Arrays.toString(arr2));
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            if (!isEqual(arr2, comparator(arr1))) {
                succeed = false;
                System.out.println("arr1" + Arrays.toString(arr1));
                System.out.println("arr2" + Arrays.toString(arr2));
                break;
            }
        }
        if (succeed) {
            Long endTime = System.currentTimeMillis();
            System.out.println("插入排序一共花费了：" + (endTime - startTime) / 1000 + "s");
        }
        System.out.println(succeed ? "Nice!" : "Fucking fuck!");
    }

    @Test
    public void testHeapSort() {
        InsertSort is = new InsertSort();
        int maxSize = 200;
        int maxValue = 1000;
        int testTime = 5000000;
        boolean succeed = true;
        int arr1[] = generateRandomArray(maxSize, maxValue);
        int arr2[] = copyArray(arr1);
        HeapSortDemo01.heapSort01(arr2);
//        System.out.println(Arrays.toString(arr2));
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            if (!isEqual(arr2, comparator(arr1))) {
                succeed = false;
                System.out.println("arr1" + Arrays.toString(arr1));
                System.out.println("arr2" + Arrays.toString(arr2));
                break;
            }
        }
        if (succeed) {
            Long endTime = System.currentTimeMillis();
            System.out.println("堆排序一共花费了：" + (endTime - startTime) / 1000 + "s");
        }
        System.out.println(succeed ? "Nice!" : "Fucking fuck!");
    }


    public static boolean isEqual(int[] arr2, int[] arr1) {
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));
    }

    // 复制一个地址不同 内容相同的数组
    private static int[] copyArray(int[] arr) {
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
        int realSize = R.nextInt(maxSize + 1);
        int[] arr = new int[realSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = R.nextInt(maxValue + 1);
        }
        return arr;
    }
}
