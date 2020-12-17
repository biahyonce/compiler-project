package com.github.biancacristina.compiler.common;

import java.util.HashMap;

public class Counter {
    private static Counter instance;
    private HashMap<String, Integer> map;

    private Counter(){
        this.map = new HashMap<String, Integer>();
    }

    public int getCount(String label) {
        this.map.putIfAbsent(label, 0);
        this.map.put(label, this.map.get(label)+1);
        return this.map.get(label);
    }

    public static Counter getInstance() {
        if(Counter.instance == null) {
            Counter.instance = new Counter();
        }
        return Counter.instance;
    }
}
