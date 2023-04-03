package linckedList;

import java.util.Stack;

public class LinckedListDemo02 {

    public static void main(String[] args) {
        SingleNode s5 = new SingleNode(8, null);
        SingleNode s4 = new SingleNode(5, s5);
        SingleNode s3 = new SingleNode(4, s4);
        SingleNode s2 = new SingleNode(2, s3);
        SingleNode s1 = new SingleNode(1, s2);

        SingleNode t5 = new SingleNode(10, null);
        SingleNode t4 = new SingleNode(5, t5);
        SingleNode t3 = new SingleNode(4, t4);
        SingleNode t2 = new SingleNode(2, t3);
        SingleNode t1 = new SingleNode(0, t2);

        SingleNode b5 = new SingleNode(1, null);
        SingleNode b4 = new SingleNode(3, b5);
        SingleNode b3 = new SingleNode(4, b4);
        SingleNode b2 = new SingleNode(3, b3);
        SingleNode b1 = new SingleNode(1, b2);
//        judgeList01(b1);
//        judgeList02(b1);
        judgeList03(t1);



    }


    /**
     * Test 2 : 给定两个 有序 链表头指针，打印其公共部分（假设两个链表长度之和为 n, 要求时间复杂度O(n)， 空间复杂度O(1)）
     * 1->2->4->5->8      0->2->4->5->10             公共部分 2->4->5
     */
    private static void commonArea(SingleNode h1, SingleNode h2) {
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
     * 3.1 利用栈进行存储时间复杂度O(2n),空间复杂度O(n)
     */
    private static void judgeList01(SingleNode head) {
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
     * 3.2 同样是利用栈，栈中存一半的数据 时间复杂度 O(n), 空间复杂度O(n/2)
     */
    private static void judgeList02(SingleNode head) {
        SingleNode p1 = head; // 慢指针 一次走一步
        SingleNode p2 = head; // 快指针 一次走两步     快指针走到末尾，慢指针走到中点
        Stack<SingleNode> s = new Stack<>();
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
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

    /**
     * 3.3 时间复杂度O(n), 使用有限变量空间复杂度O(1)
     * 快慢指针， 快指针走到终点，慢指针 走到 中点， 快指针倒走，中点赋值为 null    A--> null <---B 遍历过程对比 A 与 B的值
     * 最后将链表恢复为初始值
     */
    private static void judgeList03(SingleNode head) {
        SingleNode p1 = head; // 慢指针 一次走一步
        SingleNode p2 = head; // 快指针 一次走两步     快指针走到末尾，慢指针走到中点
        while (p2.next != null && p2.next.next != null) {  // 奇数： 1 3(p1) 1(p2)      偶数 1 3 4(p1) 3 1(p2)
            p1 = p1.next;
            p2 = p2.next.next;
        }
        SingleNode midr = p1.next;  // 右半部分第一个节点

        // 对中点后面的节点进行逆序        1 2 3(p1) 2(midr) 1 null
        SingleNode pre = null;
        while (midr != null) {
            SingleNode next = midr.next;
            midr.next = pre;
            pre = midr;
            midr = next;
        }
        boolean res = true;
        SingleNode tmpHead = head;

        // 进行比对  --> mid -->
        while (pre != null) {
            if (tmpHead.value != pre.value) {
                res = false;
                break;
            }
            pre = pre.next;
            tmpHead = tmpHead.next;
        }

        // 恢复原链表
        SingleNode p2pre = null;
        while (p2 != null) {
            SingleNode next = p2.next;
            p2.next = p2pre;
            p2pre = p2;
            p2 = next;
        }
        // p1 后半部分接恢复后的 p2
        p1.next = p2pre;
        if (res) {
            System.out.println("是回文链表！");
        } else {
            System.out.println("不是回文链表！");
        } ;
    }
}
