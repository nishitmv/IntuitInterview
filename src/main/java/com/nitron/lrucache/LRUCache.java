package com.nitron.lrucache;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }


    private final int size;
    private final Map<Integer, Integer>  map = new ConcurrentHashMap<>();
    private final LinkedList<Integer> list = new LinkedList<>();
    public LRUCache(int capacity)
    {
        this.size = capacity;

    }

    public void put(int key, int value) {
        System.out.println(list);
        if(list.size() == size)
        {
            int removableKey =  list.removeFirst();
            map.remove(removableKey);
        }
        else {
            if(!list.isEmpty())
                list.remove(Integer.valueOf(key));
        }
        list.add(key);
        map.put(key, value);
    }

    public int get(int key) {
        System.out.println(list);
        if(list.contains(key))
        {
            list.remove(Integer.valueOf(key));
            list.add(key);
            return map.get(key);
        }
        else return -1;
    }

}
