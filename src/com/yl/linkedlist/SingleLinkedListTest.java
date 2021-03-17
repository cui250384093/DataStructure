package com.yl.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author candk
 * @Description
 * @date 3/7/21 - 2:39 PM
 */
public class SingleLinkedListTest {

    @Test
    public void test1() {
        SingleLinkedList sll = new SingleLinkedList();
        Employee hero1 = new Employee(1, "宋江", "及时雨");
        Employee hero2 = new Employee(2, "吴用", "智多星");
        Employee hero3 = new Employee(3, "武松", "行者");
        Employee hero4 = new Employee(4, "李逵", "黑旋风");
        Employee hero5 = new Employee(5, "张青", "菜园子");

        sll.add(hero1);
        sll.add(hero2);
        sll.add(hero3);
        sll.add(hero4);
        sll.list();

        sll.del(hero5);
        sll.list();

        System.out.println(sll.getLength());

//        SingleLinkedList reverse = sll.reverse();
//        reverse.list();
        sll.reversedPrintList();
    }
}

/**
 *
 */
class SingleLinkedList {

    private Employee head = new Employee(0, "", "");

    /**
     *
     * @param node
     */
    public void add(Employee node) {
        getLastNode().next = node;
    }

    public void addByOrder(Employee node) {

    }

    public int getLength() {
        Employee temp = head;
        int length = 0;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public boolean del(Employee node) {
        Employee temp = head;
        boolean flag = false;

        while (true) {

            if (temp.next == null) {
                System.out.println("删除失败！");
                break;
            }

            if (temp.next == node) {
                temp.next = node.next;
                flag = true;
                break;
            }

            temp = temp.next;
        }

        return flag;
    }

    public SingleLinkedList reverse() {
        SingleLinkedList nsll = new SingleLinkedList();

        while (head.next != null) {
            Employee temp = head.next.next;
            Employee ntemp = nsll.head.next;
            nsll.head.next = head.next;
            nsll.head.next.next = ntemp;
            head.next = temp;
        }

        return nsll;
    }

    public void reversedPrintList() {
        Stack<Employee> stack = new Stack<>();
        Employee temp = head.next;

        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public Employee getLastNode() {
        Employee temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        return temp;
    }

    public void list() {
        Employee temp = head.next;

        if (temp == null) {
            System.out.println("链表为空！");
            return;
        }

        while (true) {
            System.out.println(temp.toString());
            temp = temp.next;

            if (temp == null) {
                break;
            }
        }
    }


}

/**
 *
 */
class Employee {
    public int num;
    public String name;
    public String nickname;
    public Employee next;

    public Employee() {
    }

    public Employee(int num, String name, String nickname) {
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
