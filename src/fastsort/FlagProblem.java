package fastsort;

import java.util.Arrays;

public class FlagProblem {
    public static void main(String[] args) {
        int[] arr1 = {31, 31, 21, 31, 31, 50, 31, 42, 31, 28, 31, 12, 31, 31, 67};
        int[] arr2 = {21, 50, 31, 42, 31, 28, 12, 67};
        int[] arr3 = {21, 50, 31, 42, 31, 12, 67};
//        test03(arr1, 31);
//        test03(arr2, 31);
//        test01(arr1, 31);
//        test02(arr1, 31);
//        test03(arr1, 31);
        test02(arr2, 31);
//        test03(arr3, 31);
    }

    /**
     * 1  给定一个数组arr和一个num，把 <= num 的数放在数组左边，>= num 的数放在 num 右边
     * 要求时间复杂度 O(n),空间复杂度读O(1);
     * 设置一个左边界存放小于 num 的数，每次遍历到一个小于的数，左边界右扩，该数与左边界最右边的数交换
     */
    public static void test01(int[] arr, int num) {
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < num) {
                swap(arr, left, i);
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 2.1  给定一个数组arr和一个num，把 < num 的数放在数组左边，=num 放在中间， >= num 的数放在 num 右边
     * 要求时间复杂度 O(n),空间复杂度读O(1);
     * num 的 index 为参考对象
     */
    public static void test02(int[] arr, int num) {   // 21, 50, 31, 42, 31, 28, 12, 67  31
        int left = 0; // < num 的右边界， 初始不存在赋值为 -1 ， 更新时先++ ，后交换
        int right = arr.length - 1;
        int cur = 0; // 指针当前所在位置
        while (cur < right) {
            if (arr[cur] < num) {
                swap(arr, cur, left++);
                cur++;
            } else if (arr[cur] > num) {
                swap(arr, cur, right--);   // 需要比较 交换后的元素 本次 cur不做调整
            } else {
                cur++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 2.2 严格进行分割 [0    ln |num,num,num| r1    rn]
     * less             more
     */
    public static void test03(int[] arr, int num) {
        int less = -1; //小于 num 的边界
        int more = arr.length - 1; // 最后一个 num的位置
        for (int i = 0; i <= more; i++) {
            if (arr[i] < num) {
                swap(arr, ++less, i);
            } else if (arr[i] > num) {
                swap(arr, more--, i);
                i--;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("less: " + less);
        System.out.println("more: " + more + 1);
    }

    public static void swap(int arr[], int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
