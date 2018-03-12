package net.lol365.argorithms.tests.queue;

import net.lol365.argorithms.queue.FArrayQueue;
import org.junit.Test;

public class QueueTest {

    @Test
    public void test() {
        int x = -1 % 10;
        System.out.println(x);
    }

    @Test
    public void test2() {
        FArrayQueue<Integer> queue = new FArrayQueue<Integer>();
        for(int i=0; i<100; i++) {
            queue.add(i);
        }

        for(int i=0; i<100; i++) {
            Integer element = queue.remove();
            System.out.println(element);
        }
    }

}
