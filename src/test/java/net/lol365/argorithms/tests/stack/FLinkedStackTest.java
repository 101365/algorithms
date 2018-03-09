package net.lol365.argorithms.tests.stack;

import net.lol365.argorithms.model.User;
import net.lol365.argorithms.stack.FLinkedStack;
import net.lol365.argorithms.stack.FStack;
import org.junit.Test;

public class FLinkedStackTest {

    @Test
    public void test() {
        FStack<User> stack = new FLinkedStack<User>();
        for(int i=0; i<100; i++) {
            stack.push(new User());
            System.out.println(i + " => " + stack.size());
        }

        for(int i=100; i>0; i--) {
            stack.pop();
            System.out.println(i + " => " + stack.size());
        }
    }

}
