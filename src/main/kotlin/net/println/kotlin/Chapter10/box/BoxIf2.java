package net.println.kotlin.Chapter10.box;

import java.util.Map;

public interface BoxIf2 extends Map<Integer, String> {
    String get(int key);

    String get(Integer key);
}
