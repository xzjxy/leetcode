package mergeExtension;

public class MyMergeSort {
//    public static void main(String[] args) {
//        int[] arr = {50, 23, 41, 80, 90, 31, 42, 12, 40,};
//        int[] arr1 = {42,56};
//        int[] arr2 = {41,78};
//        System.out.println(Arrays.toString(mergerSort(arr)));
//    }

    public static int[] mergerSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int l = 0;
        int r = arr.length - 1;
        int mid = (l + r) / 2;
        int[] larr = arrBuild(arr, 0, mid);
//        System.out.println("Larr排序前："+Arrays.toString(larr));
        int[] rarr = arrBuild(arr, mid + 1, r);
        larr = copyArray(mergerSort(larr));
        rarr = copyArray(mergerSort(rarr));
        return merge(larr, rarr);
    }

    public static int[] copyArray(int[] arr) {
        if(arr == null){
            return null;
        }
        int []res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int[] merge(int[] larr, int[] rarr) {
        int[] res = new int[larr.length + rarr.length];
        int i = 0;
        int a = 0;
        int b = 0;
        while (a < larr.length && b < rarr.length) {
            res[i++] = larr[a] <= rarr[b] ? larr[a++] : rarr[b++];
        }
        while (a < larr.length) {
            res[i++] = larr[a++];
        }
        while (b < rarr.length) {
            res[i++] = rarr[b++];
        }
        return res;
    }

    public static int[] arrBuild(int[] arr, int begain, int end) {
        int[] res = new int[end - begain + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[begain + i];
        }
        return res;
    }
}
