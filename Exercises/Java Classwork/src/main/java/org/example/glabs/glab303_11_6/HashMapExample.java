package org.example.glabs.glab303_11_6;

public class HashMapExample {
    public static void main(String[] args) {
        java.util.HashMap<Integer, String> languages = new java.util.HashMap<>();
        languages.put(1, "Java");
        languages.put(2, "Python");
        languages.put(3, "JavaScript");
        languages.put(4, "C Sharp");
        languages.put(null, null);
        System.out.println("HashMap: " + languages);
// remove element associated with key 2
        String value = languages.remove(2);
        System.out.println("Removed value: " + value);
        languages.remove(4, "C Sharp");
        //Here, the remove() method only removes the entry if the key 4 is associated with the value "C Sharp."
        System.out.println("Updated HashMap: " + languages);

        System.out.println("Size of Updated HashMap is: " + languages.size());

//copy contains of one Hashmap to another
        java.util.HashMap<Integer, String> copyHashMap = new java.util.HashMap<>();
        copyHashMap.putAll(languages);
        System.out.println("copyHashMap mappings= " + copyHashMap);
//Removal of null key
        String nullKeyValue = copyHashMap.remove(null);
        System.out.println("copyHashMap null key value = " + nullKeyValue);
        System.out.println("copyHashMap after removing null key = " + copyHashMap);
        System.out.println("Size of copyHashMap is: " + copyHashMap.size());
    }
}
