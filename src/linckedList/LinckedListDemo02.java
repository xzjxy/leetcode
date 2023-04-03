package linckedList;

import insertSort.InsertSort;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinckedListDemo2 {

    public static void main(String[] args) {
        SingleNode<Integer> s5 = new SingleNode<>(8, null);
        SingleNode<Integer> s4 = new SingleNode<>(5, s5);
        SingleNode<Integer> s3 = new SingleNode<>(4, s4);
        SingleNode<Integer> s2 = new SingleNode<>(2, s3);
        SingleNode<Integer> s1 = new SingleNode<>(1, s2);

        SingleNode<Integer> t5 = new SingleNode<>(10, null);
        SingleNode<Integer> t4 = new SingleNode<>(5, t5);
        SingleNode<Integer> t3 = new SingleNode<>(4, t4);
        SingleNode<Integer> t2 = new SingleNode<>(2, t3);
        SingleNode<Integer> t1 = new SingleNode<>(0, t2);

        SingleNode<Integer> b5 = new SingleNode<>(1, null);
        SingleNode<Integer> b4 = new SingleNode<>(2, b5);
        SingleNode<Integer> b3 = new SingleNode<>(4, b4);
        SingleNode<Integer> b2 = new SingleNode<>(2, b3);
        SingleNode<Integer> b1 = new SingleNode<>(1, b2);
        judgeList(b1);
        judgeList01(b1);


    }


    /**
     * Test 2 : 给定两个 有序 链表头指针，打印其公共部分（假设两个链表长度之和为 n, 要求时间复杂度O(n)， 空间复杂度O(1)）
     * 1->2->4->5->8      0->2->4->5->10             公共部分 2->4->5
     */
    private static void commonArea(SingleNode<Integer> h1, SingleNode<Integer> h2) {
        while (h1 != null && h2 != null) {
            if (h1.value > h2.value) {
                h2 = h2.next;
            } else if (h1.value < h2.value) {
                h1 = h1.next;
            } else {
                System.out.println(h2.value);
                h1 = h1.next;
                h2 = h2.next;
            }
        }
    }

    /**
     * Test 3 : 判断一个链表是否为回文链表 正着看反着看一样（假设两个链表长度之和为 n, 要求时间复杂度O(n)， 空间复杂度O(1)）
     * 1->2->1      1->2->5->2->1
     * 利用栈进行存储时间复杂度O(2n),空间复杂度O(n)
     */
    private static void judgeList(SingleNode<Integer> head) {
        SingleNode n1 = head;
        Stack<SingleNode> s = new Stack<>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }
        while (n1 != null) {
            if (s.pop().value != n1.value) {
                System.out.println("不是回文链表！");
                return;
            }
            n1 = n1.next;
        }
        System.out.println("是回文链表！");
    }

    /**
     * 同样是利用栈，栈中存一半的数据 时间复杂度 O(n), 空间复杂度O(n/2)
     */
    private static void judgeList01(SingleNode<Integer> head) {
        SingleNode p1 = head; // 慢指针 一次走一步
        SingleNode p2 = head; // 快指针 一次走两步     快指针走到末尾，慢指针走到中点
        Stack<SingleNode> s = new Stack<>();
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            head = head.next.next;
        }
        while (p1 != null) {
            s.push(p1);
            p1 = p1.next;
        }
        while (!s.isEmpty()) {
            if (s.pop().value != head.value) {
                System.out.println("不是回文链表！");
                return;
            }
            head = head.next;
        }
        System.out.println("是回文链表！");
    }

}
