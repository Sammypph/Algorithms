package LeetCode;

import Util.DateUtil;
import Util.TimeHelper;

import javax.swing.plaf.LabelUI;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by oakinrele on Mar, 2020
 */
public class LFUCache{
    int capacity;
    public Map<Integer,CustomValue> customLinkedHashMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        customLinkedHashMap = new LinkedHashMap<>(capacity,0.75f,true);
    }

    public int get(int key)
    {
        if(customLinkedHashMap.containsKey(key))
        {
            customLinkedHashMap.get(key).setFrequency(customLinkedHashMap.get(key).getFrequency() + 1);
            sortLinkedHashMap();
            return customLinkedHashMap.get(key).getValue();
        }

        else
        {
            return -1;
        }
    }

    public void put(int key, int value) {
         if(capacity <= 0)
         {
             return;
         }

        Set keySet;
        if(customLinkedHashMap.containsKey(key))
        {
            CustomValue customValue = customLinkedHashMap.get(key);
            customValue.setFrequency(customValue.getFrequency() + 1);
            customValue.setValue(value);
            customLinkedHashMap.put(key, customValue);
        }

        else if(customLinkedHashMap.size() == capacity)
        {
            CustomValue customValue = new CustomValue();
            customValue.setValue(value);
            customValue.setFrequency(customValue.getFrequency()+1);
            keySet = customLinkedHashMap.keySet();
            customLinkedHashMap.remove(keySet.iterator().next());
            customLinkedHashMap.put(key,customValue);
            sortLinkedHashMap();
        }

        else
        {
            CustomValue customValue = new CustomValue();
            customValue.setValue(value);
            customValue.setFrequency(customValue.getFrequency() + 1);
            customLinkedHashMap.put(key,customValue);
            sortLinkedHashMap();
        }

    }

    public void sortLinkedHashMap()
    {
        List<Map.Entry<Integer, CustomValue>> entries = new ArrayList<>(customLinkedHashMap.entrySet());
        //Comparator comparator = Collections.reverseOrder();
        Collections.sort(entries, new Comparator<Map.Entry<Integer, CustomValue>>() {
            @Override
            public int compare(Map.Entry<Integer, CustomValue> o1, Map.Entry<Integer, CustomValue> o2) {
                return ((o1.getValue()).getFrequency()) == ((o2.getValue()).getFrequency())? ((o2.getValue()).getFrequency()) - ((o1.getValue()).getFrequency())
                :((o1.getValue()).getFrequency()) - ((o2.getValue()).getFrequency());
            }
        });

        customLinkedHashMap.clear();
        for (Map.Entry<Integer, CustomValue> entry : entries)
        {
            customLinkedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("HERE");
    }


    public static void main(String [] args)
    {
        LFUCache cacheLFU = new LFUCache(0);
////        cacheLFU.put(2, 2);     //Frequency is 1
////        cacheLFU.put(1, 1);     //Frequency is 1
////        cacheLFU.get(2);        // returns 2   ... Frequency is 2
////        cacheLFU.get(1);        // returns 1   .... Frequency is 2
////        cacheLFU.get(2);        // returns 2   .... Frequecy is 3
////        cacheLFU.put(3, 3);     // Fequency is 1
////        cacheLFU.put(4, 4);    // evicts key 3 ... Frequency is 1
////        cacheLFU.get(3);       // returns -1
////        cacheLFU.get(2);       // returns 2
////        cacheLFU.get(1);       // returns 1
////        cacheLFU.get(4);       // returns 4
//
//        cacheLFU.put(1,1);
//        cacheLFU.put(2, 2);
//        cacheLFU.get(1);       // returns 1
//        cacheLFU.put(3, 3);    // evicts key 2
//        cacheLFU.get(2);       // returns -1 (not found)
//        cacheLFU.get(3);
//        cacheLFU.put(4, 4);    // evicts key 1
//        cacheLFU.get(1);       // returns -1 (not found)
//        cacheLFU.get(3);       // returns 3
//        cacheLFU.get(4);

//        cacheLFU.put(3,1);
//        cacheLFU.put(2,1);
//        cacheLFU.put(2,2);   // returns 1
//        cacheLFU.put(4,4);   // evicts key 2
//        cacheLFU.get(2);     // returns -1 (not found)
//        cacheLFU.put(0,0);
//        cacheLFU.get(0);

    }

}


class CustomLinkedHashMap extends LinkedHashMap<Integer,CustomValue> implements Comparable<CustomLinkedHashMap> {
    public int frequency = 0;

    CustomLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }


    @Override
    public int compareTo(CustomLinkedHashMap customLinkedHashMap) {
        return this.frequency - customLinkedHashMap.frequency;
    }


    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}


class CustomValue implements  Comparable<CustomValue>
{
    public int value;
    public int frequency = 0;

    CustomValue() { }

    CustomValue(int value, int frequency)
    {
        this.value = value;
        this.frequency = frequency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(CustomValue anotherValue)
    {
        return  this.getFrequency() - anotherValue.getFrequency();
    }
}


class CustomComparator implements Comparator<CustomValue>
{
    @Override
    public int compare(CustomValue firstValue, CustomValue secondValue)
    {
        return firstValue.getFrequency() - secondValue.getFrequency();
    }
}
