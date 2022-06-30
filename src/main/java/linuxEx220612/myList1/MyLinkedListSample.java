package linuxEx220612.myList1;

public class MyLinkedListSample {

    private SinglyLinkedNode head = null;

    static class SinglyLinkedNode {
        int val;
        SinglyLinkedNode next = null;

        SinglyLinkedNode(int v) {
            val = v;
        }
    }

    public MyLinkedListSample() {
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }

        SinglyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return -1;
            }
            // Move to Index (i + 1)
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new SinglyLinkedNode(val);
            return;
        }

        SinglyLinkedNode node = new SinglyLinkedNode(val);
        node.next = head;
        head = node;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new SinglyLinkedNode(val);
            return;
        }

        SinglyLinkedNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        SinglyLinkedNode node = new SinglyLinkedNode(val);
        cur.next = node;
    }

    public void addAtIndex(int index, int val) {
        if (head == null) {
            if (index == 0) {
                head = new SinglyLinkedNode(val);
            }
            return;
        }

        SinglyLinkedNode prev = null;
        SinglyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return;
            }
            // Move to Index (i + 1)
            prev = cur;
            cur = cur.next;
        }

        SinglyLinkedNode node = new SinglyLinkedNode(val);
        if (prev == null) {
            node.next = head;
            head = node;
        } else if (cur == null) {
            cur = node;
            prev.next = cur;
        } else {
            prev.next = node;
            node.next = cur;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        SinglyLinkedNode prev = null;
        SinglyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return;
            }
            // Move to Index (i + 1)
            prev = cur;
            cur = cur.next;
        }

        SinglyLinkedNode next = cur.next;
        if (prev == null) {
            head = head.next;
        } else if (next == null) {
            prev.next = null;
        } else {
            prev.next = next;
        }
    }
}