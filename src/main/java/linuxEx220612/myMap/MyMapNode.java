package linuxEx220612.myMap;

public class MyMapNode {

    String key;
    String value;
    MyMapNode next = null;

    public MyMapNode(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
