package ProxyTestPerformance;

import bucketSort.BucketSortDemo;
import fastsort.FastSortAll;
import heapSort.HeapSortDemo01;
import insertSort.InsertSort;
import mergeExtension.MergeSortPublic02;
import mergeExtension.MyMergeSort;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class AllSortSample implements AllSort {
    public static int[] arr;
    public static Random R = new Random();

    @Override
    public void MergeSort(int[] arr) {
        MergeSortPublic02.mergeSort(arr);
    }


    @Override
    public int[] MyMergeSort(int[] arr) {
        return MyMergeSort.mergerSort(arr);
    }

    @Override
    public int[] InsertSort(int[] arr) {
        return InsertSort.insertSort01(arr);
    }

    @Override
    public void FastSort(int[] arr) {
        FastSortAll.fastSort(arr);
    }

    @Override
    public void HeapSort(int[] arr) {
        HeapSortDemo01.heapSort01(arr);
    }

    @Override
    public void BucketSort(int[] arr) {
        BucketSortDemo.bucketSort(arr);
    }

    public static void FastSort(int[] arr, int l, int r) { // l:左闭 r:右开
        FastSortAll.fastSort01(arr);
    }
}
