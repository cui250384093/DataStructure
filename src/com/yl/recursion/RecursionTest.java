package com.yl.recursion;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/12/21 - 2:56 PM
 */
public class RecursionTest {

    @Test
    public void test1() {
        int i = test2(3);
        System.out.println(i);

    }


    /**
     * 递归调用规则
     * 1. 当程序执行到一个方法时，就会开辟一个独立的空间（栈）
     * 2. 每个空间的数据（局部变量），是独立的，如果方法中使用的是引用类型变量，就会共享该引用类型的数据
     * 3. 递归必须向退出递归的条件逼近，否则就是无限递归, 出现StackOverflowError，死归了
     * 4. 当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或返回时，该方法也就执行完毕
     * @param n
     */
    public void test(int n) {
        if (n > 2) {
            test(n - 1);
        }

        System.out.println("n = " + n);
    }

    public int test2(int n) {
        return n == 1? 1: n * test2(n - 1);
    }

}
