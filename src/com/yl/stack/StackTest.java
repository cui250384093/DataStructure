package com.yl.stack;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author candk
 * @Description
 * @date 3/9/21 - 11:24 AM
 */
public class StackTest {

    @Test
    public void ArrayStackTest() {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 添加数据到栈（入栈）");
            System.out.println("pop: 从栈取出数据（出栈）");

            key = scanner.nextLine();

            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.print("输入入栈数据：");
                    stack.push(scanner.nextInt());
                    break;
                case "pop":
                    try {
                        System.out.println("出栈数据为：" + stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
            System.out.println("程序退出。");
        }
    }
}
