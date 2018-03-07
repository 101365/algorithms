package net.lol365.argorithms.stack;

/**
 * 基于数组实现的栈
 * @param <T>
 */
public class FArrayStack<T> implements FStack<T> {

    private int size;

    private T[] array;

    public FArrayStack() {
        array = (T[])new Object[16];
    }

    public void push(T t) {
        if (array.length == size) {
            // 满栈扩容
            extend();
        }
        array[size++] = t;
    }

    /**
     * 扩容
     */
    private synchronized void extend() {
        T[] fresh = (T[])new Object[array.length * 2];
        for(int i=0; i<array.length; i++) {
            fresh[i] = array[i];
        }
        array = fresh;
    }

    public T pop() {
        if (empty()) {
            return null;
        }
        if (size * 1.0 / array.length < 0.25) {
            turnHalf();
        }
        T t = array[size-1];
        array[--size] = null;
        return t;
    }

    /**
     * 缩容
     */
    private synchronized void turnHalf() {
        T[] fresh = (T[])new Object[array.length / 2];
        for(int i=0; i<array.length; i++) {
            fresh[i] = array[i];
        }
        array = fresh;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

}
