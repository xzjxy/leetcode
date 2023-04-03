package MergeDemo01;

import org.junit.Test;

import java.util.Map;
import java.util.Random;

public class RecusionDemo04 {
    @Test
    public void test01() {
        Random r = new Random();
        int L = r.nextInt(1, 1000);
        int R = r.nextInt(1000, 600000);
        for (int i = 0; i < 1000000000; i++) {
            int res1 = (R + L) / 2;
            int res2 = L + ((R - L) >> 1);
            if (res1 != res2) {
                System.out.println("L: " + L + "\t" + "R: " + R);
                System.out.println("res1: " + res1 + "\t" + "res2: " + res2);
            }
        }
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) { // [L,R]范围只有一个数 返回 该数
            return arr[L];
        }
        int mid = L + ((R - L) >> 1); // 防止溢出 不采用（（L+R）/2）
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
