package net.println.kotlin;

public class TypeCast {
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(((Child) parent).getName());

//        if (parent instanceof Child) {
//            System.out.println(((Child) parent).getName());
//        }
        Parent parent1 = new Parent();
//        System.out.println(((Child) parent1).getName());强转失败
    }
}
