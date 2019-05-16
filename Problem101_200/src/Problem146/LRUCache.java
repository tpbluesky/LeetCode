package Problem146;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int max_capacity = 0;

    public LRUCache(int capacity) {
        super(capacity);
        this.max_capacity = capacity;
    }

    public int get(int key) {
        if (super.containsKey(key)) {
            int val = super.get(key);
            super.remove(key);
            put(key, val);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > this.max_capacity;
    }
}