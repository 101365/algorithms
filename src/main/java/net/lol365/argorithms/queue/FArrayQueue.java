package net.lol365.argorithms.queue;

/**
 * 基于数组实现的队列，考虑以下几点：
 * 1.底层数组可以根据当前队列中元素的数量自动扩容和缩容
 * 2.当队列容量不变时，采用循环队列，减少新增或者移除时元素的移动
 * @param <E>
 */
public class FArrayQueue<E> implements FQueue<E> {

    private static final int MIN_CAPACITY = 16;

    private E[] queue;
    private int top;
    private int capacity;
    private int size;

    public FArrayQueue() {
        queue = (E[]) new Object[MIN_CAPACITY];
        capacity = MIN_CAPACITY;
        top = -1;
    }

    /**
     * 新增
     * @param e
     * @return
     */
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("要插入的元素为空");
        }
        return offer(e);
    }

    /**
     * 新增
     * @param e
     * @return
     */
    public boolean offer(E e) {
        if (e == null) {
            return false;
        }
        // 判断容量是否需要扩展
        ensureCapacity();
        queue[size++] = e;
        top++;
        top %= capacity;
        return true;
    }

    /**
     * 判断容量是否需要修改
     */
    private synchronized void ensureCapacity() {
        if (size == capacity - 1) {
            // 扩容
            E[] temp = (E[]) new Object[capacity * 2];
            for(int i=0; i<size; i++) {
                temp[i] = queue[i];
            }
            capacity *= 2;
            queue = temp;
        } else if (capacity > MIN_CAPACITY * 2 && size * 1.0 / capacity < 0.25) {
            // 缩容
            int cap = capacity / 2 < MIN_CAPACITY ? MIN_CAPACITY : capacity / 2;
            E[] temp = (E[]) new Object[cap];
            for(int i=0; i<size; i++) {
                temp[i] = queue[i];
            }
            capacity = cap;
            queue = temp;
        }
    }

    /**
     * 移除并返回头部元素
     * @return
     */
    public E remove() {
        return poll();
    }

    public E poll() {
        if (top == -1) {
            return null;
        }
        E node = queue[top];
        top--;
        top %= capacity;
        size--;
        return node;
    }

    public E element() {
        return peek();
    }

    public E peek() {
        return queue[top];
    }

}
