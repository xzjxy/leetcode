package Fastsort;

import java.util.Arrays;
import java.util.Random;

public class FastSort01 {
    public static Random R = new Random();

    public static void main(String[] args) {
        int[] arr1 = {31, 31, 21, 31, 31, 50, 31, 42, 31, 28, 31, 12, 31, 31, 67};
        int[] arr2 = {21, 50, 31, 42, 31, 12, 67, 28};
//        fastSort01(arr1);
        fastSort(arr1);
        fastSort(arr2);
//        test01(5);
    }


    /**
     * 快排 1.0： 每次从最右边num开始,小于num放在左边，大于num放在右边
     * 快排 3.0： 随机选择一个数与最后一个数进行交换，长期期望值是 O(n*log(n))
     * 差情况O(n^2) ,
     */
    private static void fastSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        fastSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void fastSort(int[] arr, int l, int r) { // l:左闭 r:右开
        if (l < r) {
//            swap(arr, R.nextInt(l, r), r);  //[l,r) 快排3.0： 左闭右开区间 随机选一个数与 最后一个数进行交换(无这行变成每次选择最后一个元素复杂度介于 O(n*log(n)~ O(n^2))) 之间
            int p = partition01(arr, l, r); // p: 第一次操作后该元素所处的位置，< num 的最右边元素
            fastSort(arr, l, p - 1);
            fastSort(arr, p + 1, r);
        }

    }

    /**
     * @param arr 每次与最后一个数进行交换
     * @param l   0
     * @param r   arr.length - 1
     * @return p:  < num 的右边界 [  <num    |p|  >num   ]
     */
    private static int partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int pivot = arr[r]; // 基准值
        for (int j = l; j < more; j++) { // j 指针, 终止条件  j == more
            if (arr[j] < pivot) {
                swap(arr, ++less, j);
            }
        }
        swap(arr, less + 1, r); // 对前 len-1 的元素看完后进行 将 piviot 的位置

        return less + 1;
    }

    /**
     * @param arr 每次与第一个数进行交换
     * @param l   0
     * @param r   arr.length - 1
     * @return p[0]: <=num 的右边界  p[1]: >=num 的左边界
     */
    private static int partition01(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        int pivot = arr[r]; // 基准值
        for (int j = l; j < more; j++) { // j 指针, 终止条件  j == more
            if (arr[j] > pivot) {
                swap(arr, more--, j);
            }
        }
        swap(arr, more, r); // 对前 len-1 的元素看完后进行 将 piviot 的位置

        return more;
    }

    //数组两个元素交换
    public static void swap(int arr[], int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
