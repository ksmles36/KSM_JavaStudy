package linuxEx220612.myMap;

public class MyMap {

    private MyMapNode head = null;

    public void set(String key, String value) {
        if (head == null) {
            head = new MyMapNode(key, value);
            return;
        }

        MyMapNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        MyMapNode node = new MyMapNode(key, value);
        if(node.key.equalsIgnoreCase("") || node == null)
            return;
        cur.next = node;
    }

    public String get(String key) {
        MyMapNode cur = head;

        while (cur != null) {
            if (cur.key.equalsIgnoreCase(key)) {
                return cur.value;
            }
            cur = cur.next;
        }

        if (cur == null)
            return "값이 없습니다.";

        return cur.value;
    }

    public void show() {
        MyMapNode cur = head;

        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

}
