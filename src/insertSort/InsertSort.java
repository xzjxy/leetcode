package mergeExtension;

import java.util.Arrays;

public class InsertSort {
    public InsertSort() {
    }
    /**
     * 插入排序：扑克牌思路， 先满足 0-1 有序， 然后是 0-2  .... 一直到 0-n 有序
     * 时间复杂度 O(n^2)   空间复杂度  O(1)
     * 插入排序在时间复杂度在 O(1) 到 O(n^2) 之间，某些清空下表现由于 选择排序 和 冒牌排序，选择排序与冒泡排序严格的O(n^2)
     */
    public  static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = 1; i <= arr.length - 1; i++) { // 每次新加进来的 元素 编号 i
            for (int j = 0; j < i; j++) {  // 新加进来的元素与前面 i - 1 个元素进行比较， 插入正确的位置
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
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


}
