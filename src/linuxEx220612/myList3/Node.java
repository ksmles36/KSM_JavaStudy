package linuxEx220612.myList3;

public class Node {

    int value;
    Node next = null;
    Node cur = new Node(3);

    public Node(int value) {
        this.value = value;
    }

    public void add(int value) {
        this.value = value;
        this.next = new Node(value);
    }

    public void show() {
        System.out.println(this.cur.value);
        this.cur = this.next;
    }
}
