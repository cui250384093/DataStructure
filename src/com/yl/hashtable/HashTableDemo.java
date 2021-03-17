package com.yl.hashtable;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/17/21 - 1:49 PM
 */
public class HashTableDemo {

    @Test
    public void HashTableTest1() {
        EmployeeLinkedList list = new EmployeeLinkedList();
        Employee emp1 = new Employee("Lily");
        list.tailPush(emp1);
        list.show();
    }
}
