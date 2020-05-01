package FireCode;
import java.util.*;

/**
 * Created by oakinrele on Feb, 2020
 */
public class LRUCache {
    public int capacity;
    public Map<Integer,Integer> linkedHashMap;
    public Deque<Integer> deque = new LinkedList<>();



    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>();
    }


    //1,1
    //2,2 {1,1}{2,2}
    //get(1)   {2,2},{1,1}
    //3,3
    //

    int get(int key) {
        if(linkedHashMap.containsKey(key))
        {
            Integer key_id = key;
            Integer value_id = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            put(key_id,value_id);
                return linkedHashMap.get(key);
        }

        else
        {
            return -1;
        }
    }

    void put(int key, int value) {
      Set keySet = linkedHashMap.keySet();
        if(linkedHashMap.containsKey(key))
        {
            linkedHashMap.remove(key);
        }

      if(linkedHashMap.size() == capacity)
      {
          linkedHashMap.remove(keySet.iterator().next());
      }

        linkedHashMap.put(key,value);

    }


    public static void main(String [] args)
    {
        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4

        cache.get(2);// -1
        cache.put(2,6); //Put
        cache.get(1); // -1
///["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        cache.put(1,5); // Puts
        //{2,6} {1,5}

        cache.put(1,2); // //remove {2,6}   output {1,5}{1,2}; Update value at key 1

        cache.get(1);
        cache.get(2);

    }

}

//Using AccessOrder
class CacheLRU
{
    public int capacity;
    Map<Integer,Integer> linkedHashMap;

    public CacheLRU(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>(capacity,0.75f,true);
    }

    int get(int key) {
        if(linkedHashMap.containsKey(key))
        {
            return linkedHashMap.get(key);
        }

        else
            {
                return -1;
            }
    }

    void put(int key, int value)
    {
        Set keySet = linkedHashMap.keySet();
        if(linkedHashMap.containsKey(key))
        {
            linkedHashMap.put(key,value);
        }

        else
        if(linkedHashMap.size() == capacity)
        {
            linkedHashMap.remove(keySet.iterator().next());
        }

        linkedHashMap.put(key,value);
    }


    public static void main(String [] arg)
    {
        CacheLRU cacheLRU = new CacheLRU(2);
//        cacheLRU.put(1, 1);
//        cacheLRU.put(2, 2);
//        cacheLRU.get(1);       // returns 1
//        cacheLRU.put(3, 3);    // evicts key 2
//        cacheLRU.get(2);       // returns -1 (not found)
//        cacheLRU.put(4, 4);    // evicts key 1
//        cacheLRU.get(1);       // returns -1 (not found)
//        cacheLRU.get(3);       // returns 3
//        cacheLRU.get(4);       // returns 4


        cacheLRU.get(2);// -1
        cacheLRU.put(2,6); //Put
        cacheLRU.get(1); // -1
///["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        cacheLRU.put(1,5); // Puts
        //{2,6} {1,5}

        cacheLRU.put(1,2); // //remove {2,6}   output {1,5}{1,2}; Update value at key 1

        cacheLRU.get(1);
        cacheLRU.get(2);
    }
}


class CacheLRUEldestElement
{
    public static int capacity;
    Map<Integer,Integer> linkedHashMap;

    public CacheLRUEldestElement(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new MyLinkedHashMap<>(capacity,0.75f,true);
    }

    int get(int key)
    {
        return linkedHashMap.getOrDefault(key,-1);
    }

    void put(int key, int value)
    {
        linkedHashMap.put(key,value);
    }


    public static void main(String [] arg)
    {
        CacheLRUEldestElement cacheLRU = new CacheLRUEldestElement(1);
//        cacheLRU.put(1, 1);
//        cacheLRU.put(2, 2);
//        cacheLRU.get(1);       // returns 1
//        cacheLRU.put(3, 3);    // evicts key 2
//        cacheLRU.get(2);       // returns -1 (not found)
//        cacheLRU.put(4, 4);    // evicts key 1
//        cacheLRU.get(1);       // returns -1 (not found)
//        cacheLRU.get(3);       // returns 3
//        cacheLRU.get(4);       // returns 4


//        cacheLRU.get(2);// -1
//        cacheLRU.put(2,6); //Put
//        cacheLRU.get(1); // -1
/////["LRUCache","get","put","get","put","put","get","get"]
////[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
//        cacheLRU.put(1,5); // Puts
//        //{2,6} {1,5}
//
//        cacheLRU.put(1,2); // //remove {2,6}   output {1,5}{1,2}; Update value at key 1
//
//        cacheLRU.get(1);
//        cacheLRU.get(2);
//        cacheLRU.put(3,3);
//        cacheLRU.get(3);


        cacheLRU.put(2,1);
        cacheLRU.get(2);
        cacheLRU.put(3,2);
        System.out.println(cacheLRU.get(2));
        cacheLRU.get(3);
    }


}

class MyLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final int MAX_ENTRIES = CacheLRUEldestElement.capacity;

    public MyLinkedHashMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

}
