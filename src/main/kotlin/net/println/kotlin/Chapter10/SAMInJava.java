package net.println.kotlin.Chapter10;

import java.util.ArrayList;

public class SAMInJava {
    private ArrayList<Runnable> runnables = new ArrayList<Runnable>();

    public void addTask(Runnable runnable) {
        runnables.add(runnable);
        System.out.println("After add: " + runnable + ", we have" + runnables.size() + "in all");
    }

    public void removeTask(Runnable runnable) {
        runnables.remove(runnable);
        System.out.println("After remover:" + runnable + ", only" + runnables.size() + "left");

    }
}
