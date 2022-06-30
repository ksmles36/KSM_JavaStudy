package java1;

public class ForLoop {

    private int in;
    private int result;

    public ForLoop(int in) {
        this.in = in;
        this.result = 0;
    }

    public int forLoop() {
        for (int i = 2; i <= this.in; i+=2)
            this.result += i;
        return this.result;
    }

}
