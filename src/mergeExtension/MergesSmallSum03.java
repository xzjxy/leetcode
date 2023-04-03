package mergeExtension;

public class MergesSmallSum03 {
    /**
     1 小和问题：每个数组左边比当前数小的数累加起来，叫做数组的小和，计算数组的小和
     每次左边与右边交换，以为右边往后所有数比左边该数大
     */
    public static int smallSum = 0;

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int[] arr1 = {1, 2, 1, 2};
//        mergeSort(arr);
        System.out.println(smallSum(arr));
        System.out.println(smallSum(arr1));
    }

    private static int smallSum(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = (L + R) / 2;
        return (process(arr, L, mid) +
                process(arr, mid + 1, R) +
                merge(arr, L, mid, R));
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int tmpSum = 0;
        int i = 0;
        int a = l;
        int b = mid + 1;
        while (a <= mid && b <= r) {
            tmpSum += arr[a] < arr[b] ? arr[a] * (r - b + 1) : 0; // 注意：相等时必须左边先进栈
            tmp[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
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
        return tmpSum;
    }
}
