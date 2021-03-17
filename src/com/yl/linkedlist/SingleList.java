package com.yl.linkedlist;

/**
 * @author candk
 * @Description
 * @date 3/17/21 - 2:03 PM
 */
public class SingleList <T> {
    private Entry head;

    class Entry{
        private T data;
        private Entry next;

        public Entry() {
        }

        public Entry(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SingleList() {
        this.head = new Entry();
    }

    public void headPush(T data) {
        Entry entry = new Entry(data);
        entry.next = head.next;
        head.next = entry;
    }

    public void tailPush(T data) {
        Entry entry = new Entry(data);
        Entry var = head;
        while (var.next != null) {
            var = var.next;
        }
        var.next = entry;
        entry.next = null;
    }

    public int getLength() {
        Entry var = this.head;
        int length = 0;
        while (var.next != null) {
            length++;
            var = var.next;
        }
        return length;
    }

    public void posPush(int pos, T data) {
        if(pos < 0 || pos > getLength()) {
            return;
        }
        Entry entry = new Entry(data);
        Entry var = this.head;
        for (int i = 0; i <= pos - 1; i++) {
            var = var.next;
        }
        entry.next = var.next;
        var.next = entry;
    }

    public boolean pop(T data) {
        Entry var = head.next;
        while (var != null) {
            if (var.next.data == data) {
                var.next = var.next.next;
                return true;
            }
            var.next = var;
        }
        return false;
    }

    public void show() {
        Entry var = this.head;
        while (var.next != null) {
            System.out.println(var.next.data);
            var = var.next;
        }
    }


}
