package net.lol365.argorithms.queue;

public interface FQueue<E> {

    /**
     * 在不违背容量限制的前提下，将元素插入到当前队列
     * 会先调用offer方法，若成功，则返回true；若失败，则抛出异常
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 将元素插入到当前队列中
     * 当超过队列长度限制时，返回false
     * @param e
     * @return
     */
    boolean offer(E e);

    /**
     * 取回并且移除当前队列的头部元素
     * 该方法和poll的唯一区别是：当队列为空时，该方法会抛出一个异常
     * @return
     */
    E remove();

    /**
     * 取回并且移除当前队列的头部元素
     * 当队列为空时，返回null
     * @return
     */
    E poll();

    /**
     * 获取但是不移除队列的头部元素
     * 当队列为空时，抛出异常
     * @return
     */
    E element();

    /**
     * 获取但是不移除队列的头部元素
     * 当队列为空时，返回null
     * @return
     */
    E peek();

}
