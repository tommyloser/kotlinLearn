package net.println.kotlin.Chapter10;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class SamMain {
    public static void main(String... args) {
        //java 调用kotlin 的lambda 表达式
        SAMInKotlin samInKotlin = new SAMInKotlin();
        samInKotlin.addTask(new Function0<Unit>() {
            public Unit invoke() {
                return null;
            }
        });
    }
}
