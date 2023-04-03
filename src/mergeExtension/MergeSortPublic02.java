package MergeDemo01;

import java.util.Arrays;

public class MergeDemo {
    public static void main(String[] args) {
        int[] arr6 = {23, 40, 50, 41, 80, 90};
        mergeSort(arr6);
        System.out.println(Arrays.toString(arr6));

    }

    /**
     * 官方归并排序算法：时间复杂度根据master公式，（时间复杂度  O(nlog(n)),  空间复杂度 O(n)）
     * @param arr
     */
    private static void mergeSort(int[] arr) {
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = 0;
        int a = l;
        int b = mid + 1;
        while (a <= mid && b <= r) {
            tmp[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= mid) {
            tmp[i++] = arr[a++];
        }
        while (b <= r) {
            tmp[i++] = arr[b++];
        }
//        arr = tmp;//错误，地址赋值（不能解决问题）
        for (int j = 0; j < tmp.length; j++) {
            arr[l + j] = tmp[j]; // 精髓
        }
    }
}
