package linuxEx220612.myList2;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);

        linkedList.show();

        System.out.println();

        System.out.println("getSize() = " + linkedList.getSize());

        linkedList.remove(2);
        linkedList.show();

        System.out.println();

        System.out.println("getSize() = " + linkedList.getSize());

    }

}
