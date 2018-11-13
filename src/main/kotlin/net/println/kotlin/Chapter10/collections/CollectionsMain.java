package net.println.kotlin.Chapter10.collections;

public class CollectionsMain {
    public static void main(String... args) {
        /**
         * java 任务kotlin 的list 是自己util 的list ,但是添加element
         * 的时候却会报错， 因为这里kotlin list 没有add 方法
         */
        Test.INSTANCE.getList().add(4);
    }
}
