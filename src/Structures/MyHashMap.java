package Structures;

// TODO("Надо сделать пересоздание бакетов при больших коллизиях")

public class MyHashMap {
    int n;
    LinkedList[] bucket;

    private static class MyNode {
        int key;
        int value;
        MyNode next;

        public MyNode(int key, int value, MyNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static class LinkedList {
        MyNode head;
        int size;

        public LinkedList() {
            this.size = 0;
        }

        public int get(int key) {
            MyNode current = this.head;
            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }
                current = current.next;
            }
            return -1;
        }
        public void put(int key, int value) {
            MyNode current = this.head;
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            MyNode node = new MyNode(key, value, this.head);
            this.head = node;
        }

        public void remove(int key) {
            if (this.head == null) {
                return;
            }

            if (this.head.key == key) {
                this.head = this.head.next;
                return;
            }

            MyNode current = this.head;
            while (current.next != null) {
                if (current.next.key == key) {
                    current.next = current.next.next;
                    return;
                }
                current = current.next;
            }
        }
    }

    private int hash(int x) {
        return x % this.n;
    }

    public MyHashMap() {
        n = 991;
        bucket = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            bucket[i] = new LinkedList();
        }
    }

    public void put(int key, int value) {
        int bucketPosition = hash(key);
        bucket[bucketPosition].put(key, value);
    }

    public int get(int key) {
        int bucketPosition = hash(key);
        return bucket[bucketPosition].get(key);
    }

    public void remove(int key) {
        int bucketPosition = hash(key);
        bucket[bucketPosition].remove(key);
    }
}