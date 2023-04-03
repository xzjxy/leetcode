import org.junit.Test;

import java.util.Arrays;

public class XorDemo01 {
    /**
     * （一） 异或性质：无进位相加                                十进制       二进制（原码）     反码             补码
     * 1 任何数字异或 0 得到本身  N ^ N = 0                                 6         0000 0110      0000 0110      0000 0110
     * 2 任何数异或自己得到 0    0 ^ N = N                                 -3         1000 0011      1111 1100      1111 1101
     * 3 异或满足交换律结合律谁先谁后运算都行                         正数           原码 / 反码 / 补码 一样
     *                                                         负数           原码 / 反码：符号位不变 其余按位取反 / 补码： 符号位不变， 按位取反 + 1
     *
     * @param a
     * @param b 直接参数传递后不会影响结果， 需要用 数组 地址交换
     */
    public static void swap01(int arr[], int a, int b) {
        // 可以用的前提时两者在数组中的地址不一样，如果地址一样，二者全部变0
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }



    /**
     * 异或相关题目：
     1 在一个数组中，一种数出现奇数次，其他所有数出现偶数次，求这个数？O(n)/O(1)
     [2,2,4,4,6,6,77,77,77]
     */
    public static void xor01(int[] arr) {
        int rs = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            rs ^= arr[i + 1];
        }
        System.out.println("a"+rs);
    }

    /**
     * 异或相关题目：
     2 在一个数组中，两种数出现奇数次，其他所有数出现偶数次，求这两个数？O(n)/O(1)
     [2,2,4,4,6,6,6,77,77,77]
     a ^ b != 0, 至少存在一位分别为 0 和 1，按这位将 (a 部分重复的数）及（b 部分重复的数）分开，将问题转换为第一个问题
     */
    public static void xor02(int[] arr) {
        int rs1 = 0;
        int rs2 = 0;
        for (int i = 0; i < arr.length; i++) {
            rs1 ^= arr[i];
        }
        int right = rs1&(~rs1+1);  // 获取该书从右开始第一位不为 0 的数字
        for (int i = 0; i < arr.length; i++) {
//            if ((arr[i]&(~arr[i]+1))==2){
            if ((arr[i]& right) == 1){ // 假设 right =（000010），判断 arr[i] 第二位是不是 1
                rs2 ^= arr[i];
            }
        }
        System.out.println("a:"+(rs2));
        System.out.println("b:"+(rs1^rs2));
    }

    /**
     * 取出一个数字二进制的第 n 位 (位置从 0 开始 )
     * 7 6 5 4 3 2 1 0
     * 1 0 0 1 1 1 1 0  （78）
     * 0 1 1 0 0 0 0 1   (~78) 取反
     * 0 1 1 0 0 0 1 0  (~78+1) 取反 + 1
     */
    public int numTobit(int num, int n) {
        return num >> n & 1;
    }

    /**
     * 返回数字二进制从又开始第一位不为 0 的 位数                num           ~num       ~num+1        num&(~num+1)
     *                                                  1001110       0110001     0110010         000010 (2)
     */

    public static int rightNotZero(int num){
        return num&(~num+1);
    }
    @Test
    public void rightNotZero1() {
        System.out.println(Integer.toBinaryString(78));
        System.out.println(Integer.toBinaryString(~78));
        System.out.println(Integer.toBinaryString(~78 + 1));
        System.out.println(78&(~78+1));
    }


    @Test
    public void test() {
        int[] arr = {12, 34};
        int[] arr1 = {2, 2, 4, 4, 6, 6,6, 77, 77, 77};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        xor01(arr1);
        xor02(arr1);
        System.out.println(Integer.toBinaryString(78));
    }
}
