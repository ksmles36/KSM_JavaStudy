package linuxEx220612.myStack1_Exercise;

public class Stack {

    int top;
    String[] data;

    public Stack(int size) {
        top = -1;
        data = new String[size];
    }

    public void push(String item) {
        top += 1;
        data[top] = item;
    }

    public void pop() {
        System.out.println(data[top]);
        data[top] = null;
        top -= 1;
    }

    public void peek() {
        System.out.println(data[top]);
    }
}
