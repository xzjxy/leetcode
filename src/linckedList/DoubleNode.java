package linckedList;

public class DoubleNode<E> {
    E value;
    DoubleNode prev;
    DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        DoubleNode tmp = this.prev;
        String s = "";
        while (tmp != null) {
            s += (tmp.value + " ");
            tmp = tmp.next;
        }
        return s;
    }


}
