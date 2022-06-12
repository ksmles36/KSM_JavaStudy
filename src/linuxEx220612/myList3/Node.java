package linuxEx220612.myList3;

public class Node {

    int value;
    Node next = null;

    public Node(int value) {
        this.value = value;
    }

    public void add(int value) {
        this.next = new Node(value);
    }

    public void show() {
        System.out.println(this.next.value);
    }
}
