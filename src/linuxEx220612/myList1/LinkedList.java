package linuxEx220612.myList1;

public class LinkedList {

    Node currentNode;

    public LinkedList() {
        this.currentNode = new Node(0, null);
    }

    public void add(int value) {
        Node addedNode = new Node(value, null);
        this.currentNode.nextNode = addedNode;
        this.currentNode = addedNode;
    }

    public void printList() {
        Node cur = currentNode;
        for (int i = 0; i < 3; i++) {
            System.out.println("cur = " + cur.value);
            cur = currentNode.nextNode;
        }
    }


}
