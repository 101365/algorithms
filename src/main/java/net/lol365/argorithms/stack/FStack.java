package net.lol365.argorithms.stack;

/**
 * 栈
 * @param <T>
 */
public interface FStack<T> {

    /**
     * 入栈
     * @param t
     */
    void push(T t);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 当前栈中元素数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean empty();

}
