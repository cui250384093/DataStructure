package com.yl.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/8/21 - 10:54 AM
 */
public class DoubleLinkedListTest {

    @Test
    public void test1() {
        DoubleLinkedList dll = new DoubleLinkedList();

        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "吴用", "智多星");
        HeroNode2 hero3 = new HeroNode2(3, "武松", "行者");
        HeroNode2 hero4 = new HeroNode2(4, "李逵", "黑旋风");
        HeroNode2 hero5 = new HeroNode2(5, "张青", "菜园子");

        dll.add(hero1);
        dll.add(hero2);
        dll.add(hero3);
        dll.add(hero4);
        dll.list();
        System.out.println();

        dll.del(hero1);
        dll.list();

        System.out.println(dll.getLength());
    }
}

class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        HeroNode2 temp = head.next;

        if (temp == null) {
            System.out.println("链表为空！");
            return;
        }

        do {
            System.out.println(temp.toString());
            temp = temp.next;

        } while (temp != null);
    }

    public void add(HeroNode2 node) {
        HeroNode2 last = getLastNode();
        last.next = node;
        node.pre = last;
    }

    public HeroNode2 getLastNode() {
        HeroNode2 temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp;
    }

    public int getLength() {
        HeroNode2 temp = head;
        int length = 0;

        while (temp.next != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public boolean del(HeroNode2 node) {
        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {

            if (temp == null) {
                System.out.println("删除失败！");
                break;
            }

            if (temp == node) {
                temp.pre.next = node.next;
                if (node.next != null) {
                    node.next.pre = temp.pre;
                }
                flag = true;
                break;
            }

            temp = temp.next;
        }

        return flag;
    }
}

class HeroNode2 {
    public int num;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2() {
    }

    public HeroNode2(int num, String name, String nickname) {
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
