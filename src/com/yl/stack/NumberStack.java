package com.yl.stack;

import java.util.regex.Pattern;

/**
 * @author candk
 * @Description
 * @date 3/9/21 - 2:18 PM
 */
public class NumberStack extends ArrayStack {


    public NumberStack() {
    }

    public NumberStack(int maxSize) {
        super(maxSize);
    }

    /**
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        if(str.matches("//d *")){
            return true;
        }else{
            return false;
        }
    }
}
