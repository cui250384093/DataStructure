package com.yl.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/8/21 - 11:40 AM
 */
public class SingleCircleLinkedListTest {

    @Test
    public void test1() {
        SingleCircleLinkedList scl = new SingleCircleLinkedList();
        scl.addPerson(5);
//        scl.showList();

//        System.out.println();
//        System.out.println();

        Person nhead = scl.getHead();
        Person temp = null;
        while (true) {
            temp = scl.get(nhead, 1);
            System.out.println(temp);
            nhead = temp.getNext();
            if (nhead.getNext() == nhead) {
                System.out.println(nhead);
                break;
            }
        }
    }
}

class SingleCircleLinkedList {

    private Person first = null;

    public void addPerson(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确！");
            return;
        }

        Person curPerson = null;
        for (int i = 1; i <= nums; i++) {
            Person person = new Person(i);

            if (i == 1) {
                first = person;
                first.setNext(first);
                curPerson = first;
            } else {
                curPerson.setNext(person);
                person.setNext(first);
                curPerson = person;
            }
        }
    }

    public void showList() {
        Person curPerson = first;
        if (first == null) {
            System.out.println("List is empty.");
        } else {
            while (true) {
                System.out.println(curPerson);
                if (curPerson.getNext() != first) {
                    curPerson = curPerson.getNext();
                } else {
                    break;
                }
            }
        }
    }


    public Person get(Person head, int num) {
        Person curPerson = head;

        for (int i = 1; i < num; i++) {
            curPerson = curPerson.getNext();
        }
        Person per = curPerson.getNext();
        curPerson.setNext(curPerson.getNext().getNext());

        return per;
    }

    public Person getHead() {
        return first;
    }

}

class Person {
    private int id;
    private String name;
    private Person next;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name) {
        this.id = id;
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

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
