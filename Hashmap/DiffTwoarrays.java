package Hashmap;

import java.util.*;

public class DiffTwoarrays {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        Map<Integer,Integer>map1=new HashMap<>();
        Map<Integer,Integer>map2=new HashMap<>();

        for(int num:nums1){
            map1.put(num,map1.getOrDefault(num, 0)+1);
        }

        for(int num:nums2){
            map2.put(num, map2.getOrDefault(nums2, 0)+1);
        }

        for(int num:nums1){
            if(!map2.containsKey(num) && !list1.contains(num)){
                list1.add(num);
            }
        }

        // same work for nums2
        for(int num:nums2){
            if(!map1.containsKey(num) && !list2.contains(num)){
                list2.add(num);
            }
        }

        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
