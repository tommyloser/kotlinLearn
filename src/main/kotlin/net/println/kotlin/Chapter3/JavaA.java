package net.println.kotlin.Chapter3;

public class JavaA {
    private int b = 0;

    public int getB() {
        System.out.println("some one tries to get b");
        return b;
    }

    protected void setB(int b) {
        System.out.println("some one tries to set b");
        this.b = b;
    }
}
