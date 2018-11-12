package net.println.kotlin.Chapter9.generics;

public class Raw<T> {
    public static void main(String... args) {
        Raw raw = new Raw();//这里不写泛型实参也不报错
        System.out.println(raw);
    }

    public static Raw getRaw() {
        return new Raw();
    }
}
