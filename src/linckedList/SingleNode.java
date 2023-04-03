package linckedList;

public class SingleNode {
    int value;
    SingleNode next;

    public SingleNode() {
    }

    public SingleNode(int value, SingleNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
