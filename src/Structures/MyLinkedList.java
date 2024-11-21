package Structures;

public class MyLinkedList {

    private static class MyNode {
        int value;
        MyNode next;

        public MyNode(int value, MyNode next) {
            this.next = next;
            this.value = value;
        }
    }

    MyNode head;
    int size;
    public MyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        MyNode current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index <0 || index > size) return;
        MyNode prev = this.head;

        size++;
        if (index == 0) {
            MyNode insert = new MyNode(val, this.head);
            this.head = insert;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        MyNode insert = new MyNode(val, prev.next);
        prev.next = insert;

    }

    public void deleteAtIndex(int index) {
        System.out.println(index);
        System.out.println(size);
        if (index < 0 || index >= size) return;

        size--;

        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        MyNode prev = this.head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;


    }
}
