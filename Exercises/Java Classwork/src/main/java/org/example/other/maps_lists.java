package org.example.other;
import java.util.*;


public class maps_lists {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Map<String, String> stringMap = new HashMap<>();

        stringMap.put("key", "value");
        stringMap.put("key2", "value2");
        stringMap.put(null, "actual value");
        stringMap.put("null value", null);
        stringMap.put("otherKey", "value");

        //this will override existing value, in this case associated with null key
        stringMap.put(null, "otherValue");

        for (String key : stringMap.keySet()){
            System.out.println(key + "==" + stringMap.get(key));
        }
    }
}
