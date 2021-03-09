package com.yl.stack;

/**
 * @author candk
 * @Description
 * @date 3/9/21 - 11:13 AM
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;

    /**
     * top 代表栈顶，初始化为-1
     */
    private int top = -1;

    public ArrayStack() {
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }

        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        int temp = stack[top];
        top--;
        return temp;
    }

    /**
     *
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d.", i, stack[i]);
            System.out.println();
        }
    }

    /**
     *
     * @return
     */
    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
