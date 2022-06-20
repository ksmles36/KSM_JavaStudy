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

    public boolean push(String item) {
        if (top >= size - 1) {
            return false;
        }
        this.top += 1;
        data[top] = item;
        return true;
    }

    public String pop() {
        if (top < 0) {
            return "더이상 데이터가 없습니다!";
        }
        String result = data[top];
        data[top] = null;
        this.top -= 1;
        return result;
    }

    public void peek() {
        System.out.println("peek data = " + data[top]);
    }
}
