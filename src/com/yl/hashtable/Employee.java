package com.yl.hashtable;

/**
 * @author candk
 * @Description
 * @date 3/17/21 - 1:50 PM
 */
public class Employee {

    public int id;
    public String name;

    public Employee() {
        id++;
    }

    public Employee(String name) {
        id++;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
