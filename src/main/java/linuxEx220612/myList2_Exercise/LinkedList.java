package linuxEx220612.myList2_Exercise;

public class LinkedList {

    private Node head = null;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = new Node(value);
    }

    public void show() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value);
            cur = cur.next;
        }
    }

}
