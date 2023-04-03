package linckedList;

import java.util.*;

public class LinckedListDemo03 {
    // 给定整形单链表，整数pivot，左边的数小于 pivot / 中间等于pivot / 右边大于 pivot
    public static void main(String[] args) {
        SingleNode n7 = new SingleNode(5, null);
        SingleNode n6 = new SingleNode(5, n7);
        SingleNode n5 = new SingleNode(5, n6);
        SingleNode n4 = new SingleNode(5, n5);
        SingleNode n3 = new SingleNode(5, n4);
        SingleNode n2 = new SingleNode(5, n3);
        SingleNode n1 = new SingleNode(5, n2);

        SingleNode s1 = new SingleNode();

        display(n1);
//        SingleNode res1 = sortSingleList01(n1, 5);
//        System.out.println(res1);
        SingleNode res2 = sortSingleList02(s1, 5);
        System.out.println(res2);
//        swipNodes(n1);

    }

    // 链表打印
    private static void display(SingleNode n1) {
        SingleNode tmp = n1;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    // 交换两个节点
    private static void displayList(SingleNode[] list) {
        if (list == null) {
            System.out.println("null");
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
//                System.out.print(list[i].value + " ");
                System.out.println(list[i]);
            }
        }
    }

    // 1.1 不推荐，只是解决了问题  (丢失了数据的相对次序)
    private static SingleNode sortSingleList01(SingleNode head, int pivot) {
        int size = 0;
        SingleNode tmpHead = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        SingleNode[] list = new SingleNode[size];
        displayList(list);
        // 将 nodes 放入 list, 最好每次只放入一个节点，而不是一个部分链表
        for (int i = 0; i < list.length; i++) {
            list[i] = tmpHead;
            tmpHead = tmpHead.next;
        }
        // 将 list 的每个node下一个节点置 null
        for (int i = 0; i < list.length; i++) {
            list[i].next = null;
        }
        // 对 list 中的元素荷兰国旗排序
        int left = 0;
        int right = list.length - 1;
        int cur = 0;
        while (cur < right) {
            if (list[cur].value < pivot) {
                swap(list, cur, left++);
            } else if (list[cur].value == pivot) {
                cur++;
            } else {
                swap(list, cur, right--);
            }
        }
        SingleNode tmpHead1 = list[0];
        SingleNode newHead = list[0];
        for (int i = 1; i < list.length; i++) {
            tmpHead1.next = list[i];
            tmpHead1 = tmpHead1.next;
        }
        return newHead;
    }

    private static void swap(SingleNode[] list, int i, int j) {
        SingleNode tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    // 1.2 推荐 （定义 6 个变量，sh, st / eh, et / lh, lt）更新完后将其串起来
    private static SingleNode sortSingleList02(SingleNode head, int pivot) {
        SingleNode sH = null;   // < num 的头
        SingleNode sT = null;  // < num 的尾
        SingleNode eH = null;  // = num 的头
        SingleNode eT = null;  // = num 的尾
        SingleNode bH = null;  // > num 的头
        SingleNode bT = null;  // > num 的尾
        SingleNode tmp = head;
        if(head==null){
            return null;
        }
        while (head != null) {
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = sT.next;
                }
            } else if (head.value > pivot) {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = bT.next;
                }

            } else {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            }
            head = head.next;
        }
        if (sT == null) {
            if (eT == null) {
                sH = bH;
            } else {
                sH = eH;
                eT.next = bH;
            }
        } else {
            if (eT == null) {
                sT.next = bH;
            } else {
                sT.next = eH;
                eT.next = bH;
            }
        }
        return sH;
    }
}
