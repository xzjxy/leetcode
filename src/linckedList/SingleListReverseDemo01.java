package linckedList;

import java.util.LinkedList;

public class LinkedListDemo01 {
    /**
     * 单链表及双链表相关题目: 只需要头部节点 head，就可以找到剩下的所有节点
     * 基本数据类型是值拷贝传递，方法内调用不改变原始值，对象类型是地址转递，方法（循环）操作后会改变结果
     * 单链表 Class Node<V>{V value; Node next；}
     * 双链表 Class Node<V>{V value; Node next；Node last;}
     */
    public static void main(String[] args) {
        SingleNode<String> node1 = new SingleNode<>();
        SingleNode<String> node2 = new SingleNode<>();
        SingleNode<String> node3 = new SingleNode<>();
        SingleNode<String> node4 = new SingleNode<>();
        SingleNode<String> node5 = new SingleNode<>();
        node4 = new SingleNode<>("D", null);
        node3 = new SingleNode<>("C", node4);
        node2 = new SingleNode<>("B", node3);
        node1 = new SingleNode<>("A", node2);
        //打印当前单链表
//        printList(node1);
//        System.out.println(node5);
//        node5 = node4;
//        System.out.println(node5);
//        node4.setValue("F");
//        System.out.println(node5);
//        node1.next = node1;
//        node1 = node2;
//        printList(node1);
        System.out.println(node1.toString());
        SingleNode node = reverseList03(node1);
        System.out.println(node.toString());


//        node4.next = node3;
//        printList(node1);
//        printList(node5);
//        System.out.println(node1.toString());
//        reverseList02(node1);
//        printList(node4);
//        System.out.println(node1.toString());

    }

    /**
     * 打印列表
     */
    private static void printList(SingleNode<String> head) {
        SingleNode tmp = head;
        while (tmp.next != null) {
            System.out.print(tmp.value + "-->");
            tmp = tmp.next;
        }
        System.out.print(tmp.value);
    }

    /**
     * Test 1： 分别实现单链表和双链表的反转 要求时间复杂度 O(n)),空间复杂度O(1);
     * 指针是单向无尾的（->），Java指向同一个变量的指针是一个指针
     * 1 非递归写法（单链表）
     */
    public static SingleNode reverseList01(SingleNode<String> head) {
        if (head == null || head.next == null) {
            return head;
        }
        SingleNode nex = null;
        SingleNode pre = null;
        while (head != null) {
            nex = head.next; // next 指向当前变量的下一个元素
            head.next = pre; // head.next 指向 pre
            pre = head; //
            head = nex; // Java指向同一个变量的指针是一个指针
        }
        return pre;
    }

    /**
     * 单链表反转， 双指针           A   ->   B   ->  C  ->  D  ->  null
     * pre  cur/head    tmp
     */
    public static SingleNode reverseList02(SingleNode<String> head) {
        SingleNode pre = null;
        while (head != null) {
            SingleNode tmp = head.next; // next 指向当前变量的下一个元素
            head.next = pre; // head.next 指向 pre
            pre = head; //
            head = tmp; // Java指向同一个变量的指针是一个指针
        }
        return pre;
    }

    /**
     * 3.1 递归写法（单链表） 双参数传递
     */
    public static SingleNode reverseList03(SingleNode<String> head) {
        return recursive(head, null);
    }

    private static SingleNode recursive(SingleNode<String> cur, SingleNode pre) {
        if (cur == null) {
            return pre;
        }
        SingleNode next = cur.next;
        cur.next = pre;
        return recursive(next, cur);
    }

    /**
     * 3.2 递归写法（单链表） 单参数传递
     */
    public static SingleNode reverseList04(SingleNode<String> head) {
        if (head == null || head.next == null) {
            return head;
        }
        SingleNode newHead = reverseList04(head.next); // 黑盒表示 B之后的所有元素反转成功 所有， 下面对 B（head） 进行操作    A->B->黑盒 -> null
        head.next.next = head;  // head 本身指向黑盒 ，之后黑盒指向 head
        head.next = null; //
        return newHead;
    }


}
