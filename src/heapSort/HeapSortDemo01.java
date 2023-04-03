package heapSort;

import java.util.Arrays;
import java.util.HashSet;

public class HeapSortDemo01 {
    public static void main(String[] args) {
        int[] arr1 = {1, 50, 32, 43, 67, 32, 43, 76, 34, 53, 21, 50};
        int[] arr2 = {21, 50, 31, 42, 31, 12, 67, 28, 10, 5, 90, 42};
        heapSort01(arr1);
        heapSort01(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 堆排序： 时间复杂度O(n*log(n)) 空间复杂度 O(1) 只加入有限变量
     */
    public static void heapSort01(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        heapify(arr);
    }

    /**
     * 原数组 按层序变成 大根堆（完美二叉树）：每个子树父节点大于孩子节点 nlog(n)
     */
    public static void heapInsert(int arr[], int length) {
        int tmp;
        for (int i = 0; i <= length; i++) {
            tmp = i;
            while (arr[tmp] > arr[(tmp - 1) / 2]) {  // tmp: 当前元素编号   (tmp+1)/2： 当前元素的父节点
                swap(arr, tmp, (tmp - 1) / 2);
                tmp = (tmp - 1) / 2;
            }
        }
    }

    /**
     * 交换堆顶元素与最后一个元素，将最后一个元素放置合适位置 n(log(n))
     */
    public static void heapify(int[] arr) {
        heapInsert(arr, arr.length - 1);
        int heapSize = arr.length - 1;
        while (heapSize > 0) {
            swap(arr, 0, heapSize--);
//            System.out.println(Arrays.toString(arr));
            int i = 0;
            while (heapSize >= (2 * i + 1)) {
                int largest = arr[2 * i + 1];
                if (heapSize >= (2 * i + 2)) {
                    largest = arr[2 * i + 1] > arr[2 * i + 2] ? arr[2 * i + 1] : arr[2 * i + 2];
                }
                if (largest < arr[i]) {
                    break;
                }
                if (largest == arr[2 * i + 1]) {
                    swap(arr, i, 2 * i + 1);
                    i = 2 * i + 1;
                } else {
                    swap(arr, i, 2 * i + 2);
                    i = 2 * i + 2;
                }
            }

        }
    }

    public static void swap(int arr[], int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
