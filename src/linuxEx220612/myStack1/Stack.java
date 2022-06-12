package linuxEx220612.myStack1;

public class Stack {

    int top;
    int size;
    String[] data;

    public Stack(int size) {
        this.size = size;
        data = new String[size];
        top = -1;
    }

    public void push(String item) {
        this.top += 1;
        data[top] = item;
    }

    public void pop() {
        System.out.println("pop data = " + data[top]);
        data[top] = null;
        this.top -= 1;
    }

    public void peek() {
        System.out.println("peek data = " + data[top]);
    }
}
