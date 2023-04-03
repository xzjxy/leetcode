package leetcode_100;

public class Test01 {
    //leet-code 02 两数相加
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l2 = new ListNode(1);
        ListNode res1 = addTwoNumbers01(l1, l2);
        System.out.println(res1);
        ListNode res2 = addTwoNumbers02(l1, l2);
        System.out.println(res2);
    }

    // 方法一： 优雅的解法
    private static ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        int v1 = 0;
        int v2 = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            sum = v1 + v2 + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum > 9 ? 1 : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    // 方法二： 判断大小再处理
    public static ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        ListNode sh = l1;  // 短链
        ListNode la = l2;  // 长链
        int i = 0;
        int j = 0;
        while (sh != null) {
            i++;
            sh = sh.next;
        }
        while (la != null) {
            j++;
            la = la.next;
        }
        la = i > j ? l1 : l2;
        sh = i > j ? l2 : l1;
        ListNode res = la;
        while (sh != null) {
            int tmp = sh.val + la.val;
            la.val = tmp % 10;
            if (tmp > 9) {
                if (la.next != null) {
                    la.next.val++;
                } else {
                    la.next = new ListNode(1);
                    break;
                }
            }
            sh = sh.next;
            la = la.next;
        }
        while (la != null) {
            int tmp = la.val;
            la.val = tmp % 10;
            if (tmp > 9) {
                if (la.next != null) {
                    la.next.val++;
                } else {
                    la.next = new ListNode(1);
                    break;
                }
            }
            la = la.next;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
