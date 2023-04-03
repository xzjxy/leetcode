package mergeExtension;

public class MergeDemo01 {
    /**
     * 2 逆序对问题：在一个数组中，左边数比右边大，两个数构成一个逆序对，打印所有逆序
     */
    public static int sum = 0;

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int[] arr1 = {5, 4, 3, 2, 1};
//        mergeSort(arr);
        printReverse(arr1);
        System.out.println(sum);
    }

    private static void printReverse(int[] arr) {
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
            if (arr[a] > arr[b]) {
                for (int j = a; j <= mid; j++) {
                    System.out.print("(" + arr[j] + "," + arr[b] + ")" + " ");
                    sum += 1;
                }
            }
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
            arr[l + j] = tmp[j]; // 精髓,更新数组的局部数据
        }
    }
}
