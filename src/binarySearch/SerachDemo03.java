import java.util.Arrays;

public class SerachDemo03 {
    /**
     * 二分查找 （已经排序的数组里面 查找是否存在某个数）
     * 时间复杂度为 O(log(n))
     */

    public static void main(String[] args) {
        int[] arr1 = {23, 40, 90, 41, 32, 32, 23, 78};
        int[] arr2 = {23, 13, 12, 14, 20, 23, 89, 70, 80};
        System.out.println("原数组：" + Arrays.toString(arr1));
        BinarySearchBig(arr1, 90);
        BinarySearchSmall(arr1, 78);
        BinarySearchSmallest(arr2);
    }

    /**
     * 1 数组无序,相邻两数不等 二分法查找该数组的一个局部最小值（定义：arr[0] <= arr[1]; arr[n-2]<=arr[n-1]<=arr[n]; arr[len-2]>=arr[n];>=arr[len-1]）
       arr[0],arr[n-1],arr[len-1] 都是局部最小, 要求时间复杂度小于O(n)
     * @param arr
     */
    private static void BinarySearchSmallest(int[] arr) {
        System.out.println("原数组：" + Arrays.toString(arr));
        int begain = 0;
        int end = arr.length - 1;
        int res = 0;
        if (arr[begain] <= arr[1]) {
            System.out.println("局部最小是：" + arr[begain]);
            return;
        }
        if (arr[end] <= arr[end - 1]) {
            System.out.println("局部最小是：" + arr[end]);
            return;
        }
        while (begain <= end) {  // 必须取等号
            int mid = (begain + end) / 2;
            if (arr[mid] <= arr[mid + 1] && arr[mid - 1] >= arr[mid]) { // 满足要求是局部最小值
                res = mid;
                System.out.println("局部最小是：" + arr[res]);
                return;
            } else if (arr[mid] > arr[mid - 1]) { // 数列局部递增，局部最小在左侧
                end = mid - 1;
            } else {// 数列局部递减，局部最小在右侧
                begain = mid + 1;
            }
        }
//        System.out.println("<=" + num + "的最右位置：" + (res + 1));
    }

    /**
     * 2 二分法查找 某个数 返回 其位置
     * @param arr
     * @param num
     */
    private static void BinarySearch(int[] arr, int num) {
        Arrays.sort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
        int begain = 0;
        int end = arr.length - 1;
        while (begain <= end) {  // 必须取等号
            int mid = (begain + end) / 2;
            if (num == arr[mid]) {
                System.out.println("该数字位于数组的第" + (mid + 1) + "位！");
                return;
            } else if (num > arr[mid]) {
                begain = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("没找到这个数！");
    }

    /**
     * 3 二分法查找, 返回 >= num 最左侧的位置
     * @param arr
     * @param num
     */
    private static void BinarySearchBig(int[] arr, int num) {
        Arrays.sort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
        int begain = 0;
        int end = arr.length - 1;
        int res = 0;
        while (begain <= end) {  // 必须取等号
            int mid = (begain + end) / 2;
            if (num <= arr[mid]) {
                res = mid;
                end = mid - 1;
            } else {
                begain = mid + 1;
            }
        }
        System.out.println(">=" + num + "的最左位置：" + (res + 1));
    }

    /**
     * 4 二分法查找, 返回 <= num 最右侧的位置
     * @param arr
     * @param num
     */
    private static void BinarySearchSmall(int[] arr, int num) {
        Arrays.sort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
        int begain = 0;
        int end = arr.length - 1;
        int res = 0;
        while (begain <= end) {  // 必须取等号
            int mid = (begain + end) / 2;
            if (arr[mid] <= num) {
                res = mid;
                begain = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        System.out.println("<=" + num + "的最右位置：" + (res + 1));
    }


}
