package com.yl.queue;

/**
 * @author candk
 * @Description
 * @date 3/7/21 - 2:01 PM
 */
public class CircleArrayQueueTest {


}

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
            throw new RuntimeException("队列空！");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
