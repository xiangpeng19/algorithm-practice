package solutions.algorithms;

import org.junit.jupiter.api.Test;

class _146Test {

//    private static _146.LRUCache cache = new _146.LRUCache(2);

    @Test
    public void shouldWork() {
        _146.LRUCache cache = new _146.LRUCache(1);
        cache.put(2, 1);
        cache.get(2); // 1
        cache.put(3, 2);
        cache.get(2); // -1
        cache.get(3); // 2
    }

}