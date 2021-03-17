package com.yl.hashtable;


import com.yl.linkedlist.SingleList;
import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/17/21 - 1:51 PM
 */
public class EmployeeLinkedList extends SingleList<Employee> {

    @Test
    public void test1() {
        EmployeeLinkedList list = new EmployeeLinkedList();
        Employee emp1 = new Employee("Lily");
        list.tailPush(emp1);
        list.show();
    }
}
