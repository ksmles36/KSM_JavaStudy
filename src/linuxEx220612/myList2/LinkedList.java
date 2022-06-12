package linuxEx220612.myList2;

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
            System.out.println("cur = " + cur.val);
            cur = cur.next;
        }
    }

}
