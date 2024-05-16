package org.example.other;
import java.util.*;


public class maps_lists {
    public static void main(String[] args) {
        //maps_lists.MapsInClass();
        maps_lists.hashMap();
    }

    public static void MapsInClass(){
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

        //to assign  multiple values to one key, implement list
        Map<String, List<Integer>> listMap = new HashMap<>();
        listMap.put("Grosvenor pl", new ArrayList<Integer>());
        listMap.get("Grosvenor pl").add(10101);
        listMap.get("Grosvenor pl").add(10301);

        listMap.put("Rodeo dr", new ArrayList<Integer>());
        listMap.get("Rodeo dr").add(4578);

        List<Map<String,Object>> adHocQueryDatabase;
    }
    public static void hashMap() {
        Map<Integer, String> hash1 = new HashMap<>();

        hash1.put(2, "number two");
        hash1.put(3, "number three");
        hash1.put(4, "number four");
        hash1.put(5, "number five");

        for (Integer key : hash1.keySet()){
            System.out.println("\nIn hash 1: " + key + "==" + hash1.get(key));
        }
        int count = 0;

        for (Integer key : hash1.keySet()) {
            count++;
        }
        System.out.println("number of keys: " + count);

        Map<Integer, String> hash2 = new HashMap<>();
        hash2.putAll(hash1);
        hash1.clear();
        System.out.println("Is hash 1 empty? " + hash1.isEmpty());

        for (Integer key : hash1.keySet()){
            System.out.println("In hash 2: " + key + "==" + hash1.get(key));
        }

        System.out.println("Testing for key 1: " + hash2.containsValue(1));
        System.out.println(hash2.containsValue("Testing for value 'number five': " + "number five"));

        hash1.putIfAbsent(1,"number one");
        hash1.putIfAbsent(2,"number two");
        for (Integer key2 : hash1.keySet()){
            System.out.println(key2 + "==" + hash1.get(key2));
        }

        System.out.println(hash2.entrySet());
        System.out.println("At key 5, we have value"+hash2.get(5));
        }

    }
