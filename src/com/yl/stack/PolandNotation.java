package com.yl.stack;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author candk
 * @Description
 * @date 3/12/21 - 9:23 AM
 */
public class PolandNotation {

    @Test
    public void test1() {

        //(3 + 4) * 5 -6
        //4 * 5 - 8 + 60 + 8 / 2
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";

        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        int res = calculate(rpnList);
        System.out.println(res);
    }

    @Test
    public void test2() {

        String expression = "2+((2+3)*4)-51";
        ArrayList<String> infixExpressionList = stringToInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        ArrayList<String> suffixExpressionList = infixToSuffixExpressionList(infixExpressionList);
        System.out.println(suffixExpressionList);
        System.out.println(calculate(suffixExpressionList));
    }

    /**
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }

        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();

        int res = 0;
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        stack.push(String.valueOf(res));
                        break;
                    case "-":
                        res = num1 - num2;
                        stack.push(String.valueOf(res));
                        break;
                    case "*":
                        res = num1 * num2;
                        stack.push(String.valueOf(res));
                        break;
                    case "/":
                        res = num1 / num2;
                        stack.push(String.valueOf(res));
                        break;
                    default:
                        throw new RuntimeException("运算符有误！");
                }
            }
        }

        return res;
    }

    /**
     *
     * @param str
     * @return
     */
    public ArrayList<String> stringToInfixExpressionList(String str) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        String strTemp;
        char c;

        do {
            if ((c = str.charAt(i)) < 48 || (c = str.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                strTemp = "";
                while (i < str.length() && (c = str.charAt(i)) > 48 && (c = str.charAt(i)) < 57) {
                    strTemp += c;
                    i++;
                }
                list.add("" + strTemp);
            }
        } while (i < str.length());

        return list;
    }

    /**
     * 中缀表达式转后缀表达式的思路
     * 1. 初始化两个栈：运算符栈s1和储存中间结果的栈s2
     * 2. 从左至右扫描中缀表达式
     * 3. 遇到操作数时，将其压s2
     * 4. 遇到操作符时，比较其与s1栈顶运算符的优先级
     *   1. 如果s1为空，或栈顶运算符为“（”，则直接将此运算符入栈
     *   2. 否则，若优先级比栈顶运算符的高，也将运算符压入s1
     *   3 否则，将s1栈顶的栈顶运算符弹出并压入到s2中，再次转到（4-1）与s1中的新栈顶运算符相比较
     * 5. 遇到括号时：
     *   1. 如果是“(”,则直接压人s1
     *   3. 如果是“）”，则依次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止，此时将这一对括号丢弃
     * 6. 重复2-5，知道表达式的最右边
     * 7. 将s1中剩余的运算符依次弹出并压入s2
     * 8. 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */
    public ArrayList<String> infixToSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();

        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }

        if (s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }


}

class Operation {
    private static int ADD = 1;
    private static int SUD = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    int result = 0;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUD;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符！");
                break;
        }
        return result;
    }

}
