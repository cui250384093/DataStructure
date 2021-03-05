package com.yl.queue;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author candk
 * @Description
 * @date 3/5/21 - 3:08 PM
 */
public class ArrayQueueDemo {

    @Test
    public void test1() {

        ArrayQueue queue = new ArrayQueue(100);
        for (int i = 0; i < 20; i++) {
            queue.addQueue(i + 1);
        }

        System.out.println(queue.headQueue());
        queue.showQueue();

        System.out.println();
        System.out.println(queue.getQueue());
        queue.showQueue();
    }

    @Test
    public void test2() {

        ArrayQueue queue1 = new ArrayQueue(10);
        for (int i = 0; i < 20; i++) {
            queue1.addQueue(i);
        }
    }

    @Test
    public void test3() {

        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show) 显示队列");
            System.out.println("e(exit) 退出程序");
            System.out.println("a(add) 添加数据到队列");
            System.out.println("g(get) 从队列取出数据");
            System.out.println("h(head) 查看队列头的数据");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取出的数为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出");
    }
}

class ArrayQueue{

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue() {
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;

        arr = new int[maxSize];
        //front 指向队列头部的前一个位置
        front = -1;
        //rear 指向队列尾部的数据，即就是队列最后一个数据
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty!");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        for (int i = front + 1; i <= rear ; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty!");
        } else {
            return arr[front + 1];
        }
    }
}
