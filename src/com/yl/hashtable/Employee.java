package com.yl.hashtable;

/**
 * @author candk
 * @Description
 * @date 3/17/21 - 1:50 PM
 */
public class Employee {

    private int id;
    private static int counter;
    private String name;

    public Employee() {
        id = counter++;
    }

    public Employee(String name) {
        id = counter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
