package bucketSort;

import java.util.Arrays;

/**
 * 排序算法总结
 * 桶排序： 按位分类， 最大数的位数决定循环次数，按照位数由低到高倒入桶中，每次更新排序结果。
    排序算法稳定性：值相同的元素，不应排序改变相对顺序则是稳定的，稳定算法可以保留相对次序
     不存在 时间复杂度O(nlog(n)),空间复杂度O(1),而且稳定的排序
 *    排序          时间复杂度       空间复杂度       稳定/不稳定
    1 冒牌排序        O(n^2）         O(1)            Yes
    2 选择排序        O(n^2）         O(1)            No
    3 插入排序        O(n^2）         O(1)            Yes
    4 归并排序      O(nlog(n))        O(N)            Yes    Arrays.sort d=对于基础元素采用快排， 非基础元素采用归并排序（利用其稳定性）
    5 快读排序      O(nlog(n))      O(log(n))          No   （一般选择快排，测试效果最好）
    6 堆排序        O(nlog(n))       O(1)             No
    * 题目： 奇数放在数组左边，偶数放在右边，有限变量空间复杂度O(1)。时间复杂度O(n),而且保持相对次序不变
     经典快排 partition 可以做到，但是块排是不稳定的
 */
public class BucketSortDemo {
    public static void main(String[] args) {
        int[] arr1 = {12, 34, 50, 20, 24, 102, 320, 120};
        System.out.println(getDigital(123, 1));
        System.out.println(getMaxDigital(arr1, 0, arr1.length - 1));
        bucketSort(arr1);
//        radixSort(arr1, 2, 5);
        System.out.println(Arrays.toString(arr1));

    }

    public static void bucketSort(int[] arr) {
        radixSort(arr, 0, arr.length - 1);
    }


    public static void radixSort(int arr[], int l, int r) { // 左闭右闭
        int maxDigital = getMaxDigital(arr, l, r);
        int[] bucket = new int[r - l + 1];   // 每次更新用于存放临时数据
        for (int d = 0; d < maxDigital; d++) {  // 倒入桶中和取出元素的次数
            int[] count = new int[10];
            for (int j = l; j <= r; j++) {
                count[getDigital(arr[j], d + 1)]++;
            }
            for (int k = 1; k < count.length; k++) {
                count[k] += count[k - 1];
            }
            for (int len = r; len >= l; len--) {
                int tmp = getDigital(arr[len], d + 1); // arr[len] 的 d+1 位的数字
                bucket[--count[tmp]] = arr[len]; // count[tmp--]: <= tmp的数有多少个
            }
            for (int n = 0; n < bucket.length; n++) {
                arr[n] = bucket[n];
            }
        }

    }

    // 获取 num在某位上的数字
    private static int getDigital(int num, int d) {
        for (int i = 0; i < d - 1; i++) {
            num = num / 10;
        }
        return num % 10;
    }

    // 获取 arr 在（l-r）最大数的位数
    private static int getMaxDigital(int[] arr, int l, int r) { // 左闭右闭
        int max = arr[l];
        for (int i = l; i < r - 1; i++) {
            max = arr[i] > arr[i + 1] ? arr[i] : arr[i + 1];
        }
        int res = 1;
        while (max / 10 != 0) {
            max /= 10;
            res++;
        }
        return res;
    }

}
