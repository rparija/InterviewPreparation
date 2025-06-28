package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LeetCode146 {
    Map<Integer, Integer> map;
    int capacity;

    public LeetCode146(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int value = map.get(key);
        map.remove(key);             // move to end (most recently used)
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);         // update position
        } else if (map.size() == capacity) {
            int lruKey = map.entrySet().iterator().next().getKey();  // get LRU key
            map.remove(lruKey);
        }
        map.put(key, value);
    }

    public static void main(String[] args) {
        LeetCode146 lRUCache = new LeetCode146(2);
        /*lRUCache.get(2);    // return 1
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        lRUCache.get(1);
        lRUCache.get(2);*/
        System.out.println(lRUCache.get(2));    // return 1
        lRUCache.put(2, 6); // cache is {1=1}
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}
