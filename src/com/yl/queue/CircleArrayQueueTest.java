package com.yl.queue;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author candk
 * @Description
 * @date 3/7/21 - 2:01 PM
 */
public class CircleArrayQueueTest {

    @Test
    public void Test1() {
        //其最大有效数据为3
        CircleArray queue = new CircleArray(4);

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

/**
 * 为了与空的判断条件相区别，预留了一个空间，致最多存储maxSize - 1的数值
 */
class CircleArray {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray() {
    }

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满！");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        }

        int num = arr[front];
        front = (front + 1) % maxSize;
        return num;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空！");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        }

        return arr[front];
    }
}
