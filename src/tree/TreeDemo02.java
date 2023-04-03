package tree;

import java.util.Arrays;
import java.util.Stack;

public class TreeDemo02 {
    /**
     * A
     * B      C
     * D   E   F  G
     * H  I  J
     * 二叉树遍历：
     */
    public static void main(String[] args) {
        String[] tree = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        preOrder(tree);
    }

    /**
     * 树的 先根遍历 ：  根-->  左-->  右: A B D H I E J C F G
     * 节点编号 i   (i-1)/2  2i+1  2i+2
     */
    public static void preOrder(String[] list) {
        if (list == null || list.length < 2) {
            System.out.println(Arrays.toString(list));
            return;
        }
        int index = 0;
        Stack<String> treeStack = new Stack<>();
        while (!treeStack.empty() || list[index] != null) {
            if (findLChild(list, index) != -1) {
                System.out.println(list[2 * index + 1]);
                treeStack.push(list[2 * index + 1]);
            }
        }

    }

    private static int findLChild(String[] list, int index) {
        int tmp = index * 2 + 1;
        if (tmp >= 0 && tmp < list.length) {
            return tmp;
        } else
            return -1;
    }

    private static int findRChild(String[] list, int index) {
        int tmp = index * 2 + 2;
        if (tmp >= 0 && tmp < list.length) {
            return tmp;
        } else
            return -1;
    }

}
