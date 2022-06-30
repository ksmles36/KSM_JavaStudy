package linuxEx220612.myList3;

public class Node {

    String data = null;
    Node next;

    public Node(String data) {
        this.data = data;
    }

    public void add(String val) {
        if (data == null) {
            data = val;
        } else {
            next = new Node(val);
        }
    }

    public void show() {
        Node cur = null;
        if (cur.next == null) {
            System.out.println("값이 없습니다.");
        }else{
            System.out.println(data);

        }

    }
}
