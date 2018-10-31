package net.println.kotlin.Chapter4.innerClass;

public class InnerClassJava {
    private int a ;
    public  class Inner{ //非静态
        public void hello() {
            System.out.println(a);
        }
        //是否持有状态
    }

    public static void main(String... args) {
        InnerClassJava innerClassJava = new InnerClassJava();
//        Inner inner = new Inner();
    }
}
