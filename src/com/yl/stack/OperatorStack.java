package com.yl.stack;

/**
 * @author candk
 * @Description
 * @date 3/9/21 - 2:17 PM
 */
public class OperatorStack extends ArrayStack {

    public OperatorStack() {
    }

    public OperatorStack(int maxSize) {
        super(maxSize);
    }

    /**
     *
     * @return
     */
    public static int priority(char operator) {
        if(operator == '*' || operator == '/') {
            return 1;
        } else if(operator == '+' || operator == '-') {
            return 0;
        }else {
            return -1;
        }
    }

    /**
     *
     * @param val
     * @return
     */
    public static boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }


}
