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
        Employee emp2 = new Employee("Lucy");
        Employee emp3 = new Employee("Tom");
        list.tailPush(emp1);
        list.tailPush(emp2);
        list.tailPush(emp1);
        list.tailPush(emp3);
        list.show();
        System.out.println(list.findPosition(emp3));
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
    }
}
