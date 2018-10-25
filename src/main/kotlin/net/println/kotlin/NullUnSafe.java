package net.println.kotlin;

public class NullUnSafe {
    public static void main(String[] args) {
        String name = getName();
        if (name == null) {
            System.out.println("name is invalid!!");
        } else {
            System.out.println(getName().length());
        }
    }

    public static String getName() {
        return "";
    }
}
