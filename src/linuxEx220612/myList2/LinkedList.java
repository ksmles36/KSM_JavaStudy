package linuxEx220612.myList2;

import linuxEx220612.myList1.MyLinkedListSample;

public class LinkedList {

    private Node head = null;

    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = new Node(val);
    }

    public void show() {
        Node cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public void remove(int index) {
        Node prev = null;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return;
            }
            prev = cur;
            cur = cur.next;
        }

        Node next = cur.next;
        if (prev == null) {
            head = head.next;
        } else if (next == null) {
            prev.next = null;
        } else {
            prev.next = next;
        }
    }

    public int getSize() {
        int size = 0;

        Node cur = head;

        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
}
