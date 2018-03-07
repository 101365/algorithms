package net.lol365.argorithms.tests.stack;

import net.lol365.argorithms.model.User;
import net.lol365.argorithms.stack.FArrayStack;
import net.lol365.argorithms.stack.FStack;
import org.junit.Test;

public class FArrayStackTest {

    @Test
    public void testArrayStack() {

        int max = 100;
        FStack<User> stack = new FArrayStack<User>();
        for(int i=0; i<max; i++) {
            stack.push(new User());
            System.out.println(i + " => " + stack.size());
        }

        for(int i=0; i<stack.size(); i++) {
            User user = stack.pop();
            assert user != null;
            System.out.println(i + " => " + stack.size());
        }

    }

}
