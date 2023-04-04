package linckedList;

import java.util.HashMap;

public class Demo4 {
    /**
     * Test 4: 给定一种链表形式，rand 可能指向 空null 或者链表中的任意一个 节点， 实现复制该链表的功能， 返回新链表的头指针 (要求新老链表的头指针必须不一样)
     * 时间复杂度O(n), 空间复杂度 O(1) / 链表内部不存在环
     */
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n1.random = n3;

        n2.next = n3;
        n2.random = null;

        n3.next = n4;
        n3.random = null;


        System.out.println(n1);
//        Node newHead = copyRandomList01(n1);
        Node newHead1 = copyRandomList02(n1);
//        System.out.println(newHead);
        System.out.println(newHead1);

    }


    /**
     * 4.1 使用 HashMap 实现
     */
    private static Node copyRandomList01(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 完成对 value 的赋值
        while (cur != null) {
            map.put(cur, new Node(cur.val));  // map key and value 初始化
            cur = cur.next;
        }
        cur = head;
        // 完成连接关系
        while (cur != null) {
            map.get(cur).next = map.get(cur.next); // map.get(key) 获得 key 对应 value
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 4.2  每个节点后 复制一个与之相同的节点 / 遍历改变复制节点的连接关系
     */
    private static Node copyRandomList02(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        Node next = null;
        // 1 克隆节点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        // 2 解决克隆节点 random 指针问题
        cur = head;
        Node copyNode = null;
        while (cur != null) {
            next = cur.next.next;
            copyNode = cur.next;
            copyNode.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        // 3 拆分节点  1 -> 1' -> 2 -> 2' -> null 保证 两个链表 的 指向 都不发生变化
        cur = head;  // 1
        Node newHead = head.next; // 1'
        while (cur != null) {
            next = cur.next.next;  // 2
            copyNode = cur.next;  // 1'
            cur.next = next;   // 1 -> 2  连接 1，2
            copyNode.next = next == null ? null : next.next;
            cur = next;

        }
        return newHead;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && (nums[i] + nums[j] == target)) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return  "{"+val +
                "," + next +
                "," + random +
                '}';
    }
}