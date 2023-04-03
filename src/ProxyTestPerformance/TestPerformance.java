package ProxyTestPerformance;

import java.util.Arrays;
import java.util.Random;

public class TestPerformance {
    public static Random R = new Random();

    public static void main(String[] args) {
        AllSort as = new AllSortSample();
        AllSort ass = ProxyUtil.getProxy(as);
        int maxSize = 200;
        int maxValue = 1000;
        int testTime = 5000000;
        boolean succeed = true;
        int arr1[] = generateRandomArray(maxSize, maxValue);
        int arr2[] = copyArray(arr1);
        int arr3[] = copyArray(arr1);
        int arr4[] = copyArray(arr1);
        int arr5[] = copyArray(arr1);
        int arr6[] = copyArray(arr1);
        // fastsort
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            ass.FastSort(arr1);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("Fastsort运行时间" + (endTime - startTime) / 1000 + "s");

        // mergesort
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            ass.MergeSort(arr2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("MergeSort运行时间" + (endTime - startTime) / 1000 + "s");

        //mymergesort
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            ass.MyMergeSort(arr3);
        }
        endTime = System.currentTimeMillis();
        System.out.println("MyMergeSort运行时间" + (endTime - startTime) / 1000 + "s");

        //Insertsort
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            ass.InsertSort(arr4);
        }
        endTime = System.currentTimeMillis();
        System.out.println("InsertSort运行时间" + (endTime - startTime) / 1000 + "s");

        //heapsort
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            ass.HeapSort(arr5);
        }
        endTime = System.currentTimeMillis();
        System.out.println("HeapSort运行时间" + (endTime - startTime) / 1000 + "s");

        //bucketsort
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= testTime; i++) {
            ass.BucketSort(arr6);
        }
        endTime = System.currentTimeMillis();
        System.out.println("BucketSort运行时间" + (endTime - startTime) / 1000 + "s");
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
