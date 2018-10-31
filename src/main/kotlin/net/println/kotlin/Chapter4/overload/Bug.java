package net.println.kotlin.Chapter4.overload;

import java.util.ArrayList;
import java.util.List;

public class Bug {
    public static void main(String... args) {
//        List<Integer> integerList = new ArrayList<Integer>();
//        integerList.add(13);
//        integerList.add(1);
//        integerList.add(3);
//        integerList.add(33);
//        integerList.add(43);
//        integerList.add(4);
//        System.out.println(integerList);
//
//        integerList.remove(4);
//        System.out.println(integerList);

        Overloads overloads = new Overloads();
        overloads.a(3);//不可不传,或者方法添加 JvmOverloads
    }
}
