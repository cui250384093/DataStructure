package com.yl.linkedlist;

import org.junit.jupiter.api.Test;

/**
 * @author candk
 * @Description
 * @date 3/7/21 - 2:39 PM
 */
public class SingleLinkedListTest {

    @Test
    public void test1() {
        SingleLinkedList sll = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "吴用", "智多星");
        HeroNode hero3 = new HeroNode(3, "武松", "行者");
        HeroNode hero4 = new HeroNode(4, "李逵", "黑旋风");

        sll.add(hero1);
        sll.add(hero2);
        sll.add(hero3);
        sll.add(hero4);
        sll.list();

        sll.remove(hero1);
        sll.list();


    }
}

/**
 *
 */
class SingleLinkedList {

    private HeroNode  head = new HeroNode(0, "", "");

    /**
     *
     * @param node
     */
    public void add(HeroNode node) {
        getLastNode().next = node;
    }

    public void addByOrder(HeroNode node) {

    }

    public void remove(HeroNode node) {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                System.out.println("删除失败！");
                return;
            }

            if (temp.next == node) {
                temp.next = node.next;
                return;
            }
            temp = temp.next;
        }
    }

    public HeroNode getLastNode() {
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        return temp;
    }

    public void list() {
        HeroNode temp = head.next;

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
class HeroNode {
    public int num;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int num, String name, String nickname) {
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
