package com.yl.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author candk
 * @Description
 * @date 3/8/21 - 10:14 AM
 */
public class StackTest {

    @Test
    public void Test1() {
        Stack<String> stack = new Stack();

        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}

