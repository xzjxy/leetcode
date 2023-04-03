package setMap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SetMapDemo {
    /**
     * // map（key --> value ） 与 set(key) 的最大区别就是有无伴随数据；传入对象是基本数据类型则将数据拷贝一份/非基础类型按引用对象传递地址
     * // TreeSet 与 TreeMap 都是自带排序的， 增删改查O(log(n))级别，有序类型必须提供 （比较器）
     * // HashSet 与 HashMap 无序， 增删改查 O(1)级别 无序提供比较器
     */


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.empty());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.isEmpty());
    }
}
