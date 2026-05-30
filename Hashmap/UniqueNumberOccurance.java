package Hashmap;

import java.util.*;

public class UniqueNumberOccurance {
    public static void main(String[] args) {
        System.out.println("Is Unique Occurance are present ? "+uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 ,3,3,3 }));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer>set=new HashSet<>();
        for (Integer integer : map.values()) {
            set.add(integer);
        }
        if(map.size()!=set.size()){
            return false;
        }
        return true;
    }
}
