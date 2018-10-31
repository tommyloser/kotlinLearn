package net.println.kotlin.Chapter4;

public class StaticJava {
    public static void main(String... args) {
//        Latitude latitude = Latitude.Companion.ofDouble(3.0);
        Latitude latitude = Latitude.ofDouble(3.0);
        System.out.println(Latitude.TAG);
    }
}
