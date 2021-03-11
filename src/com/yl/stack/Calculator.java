package com.yl.stack;

import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author candk
 * @Description
 * @date 3/9/21 - 2:03 PM
 */

public class Calculator {

    /**
     * 计算思路
     * 1. 通过一个index值（索引），来遍历我们的表达式
     * 2. 如果发现是一个数字，直接入数栈
     * 3. 如果返现扫描到的是一个符号，就分如下情况：
     *  3.1 如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数，再从符号栈中pop出一个符号，
     *      进行晕眩，将得到的结果入数栈，然后将当前的操作符入符号栈，如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈。
     * 4. 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行。
     * 5. 最后在数栈中只有一个数字，就是表达式的结果。
     *
     */

    @Test
    public void test1() {

        String expression = "9+88*4-11";

        NumberStack numberStack = new NumberStack(20);
        OperatorStack operatorStack = new OperatorStack(20);
        ArrayStack stack = new ArrayStack(40);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (OperatorStack.isOper(ch)) {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(ch);
                } else {
                    if (OperatorStack.priority(ch) <= OperatorStack.priority((char) operatorStack.peek())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = operatorStack.pop();
                        res = Calculator.cal(num1, num2, oper);
                        numberStack.push(res);
                        operatorStack.push(ch);
                    } else {
                        operatorStack.push(ch);
                    }
                }
            } else {
                for (int i = index + 1; i <= expression.length(); i++) {
                    String sub = expression.substring(index, i);
                    if (i == expression.length()) {
                        int ch1 = Integer.parseInt(sub);
                        numberStack.push(ch1);
                        index = i;
                        break;
                    }
                    if (!isNumeric(sub)) {
                        String str = expression.substring(index, i - 1);
                        int chint = Integer.parseInt(str);
                        numberStack.push(chint);
                        index = i - 2;
                        break;
                    }
                }
            }

            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            if (operatorStack.isEmpty()) {
                break;
            }

            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = operatorStack.pop();
            res = Calculator.cal(num1, num2, oper);
            numberStack.push(res);
        }

        System.out.println("result = " + res);
    }

    public boolean isNumeric(String str) {
        for (int i = str.length() -1 ; i >= 0; i--) {
            char chr = str.charAt(i);
            if (chr < 48 || chr > 57) {
                return false;
            }
        }
        return true;
    }


    public static int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

}


