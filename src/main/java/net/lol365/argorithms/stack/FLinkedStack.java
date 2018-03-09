package net.lol365.argorithms.stack;

/**
 * 基于链表实现栈
 * @param <T>
 */
public class FLinkedStack<T> implements FStack<T> {

    private static final int MAX_CAP = 65535;

    /**
     * 栈容量
     */
    private int size;

    /**
     * 栈顶元素
     */
    private Node<T> top;

    /**
     * 压栈
     * @param t
     */
    public void push(T t) {
        if (size++ < MAX_CAP) {
            Node<T> tem = top;
            top = new Node<T>(t, tem);
        } else {
            throw new RuntimeException("超过了最大容量限制");
        }
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

}

class Node<T> {

    private Node<T> next;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this.next = next;
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
