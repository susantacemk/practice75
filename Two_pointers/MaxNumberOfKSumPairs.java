package Two_pointers;

import java.util.*;

// problem Link -- https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        // System.out.println(maxOperations(new int[] { 1, 2, 3, 4 }, 5));
        // System.out.println(maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));
        // System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
        // System.out.println(Arrays.toString(twoSum(new int[] { 3, 2, 4 }, 6)));
        System.out.println(countPairs(new int[] { 1, 3, 5, 7, 9 }));
    }

    public static int maxOperations(int[] nums, int k) {
        int ans = 0;
        // sort the array
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                ans = ans + 1;
                left++;
                right--;
            } else {
                if (nums[left] + nums[right] < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    // 1. Two Sum -- same to above problem
    // https://leetcode.com/problems/two-sum/description/
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = { -1, -1 };
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            int remainingElement = target - currentElement;
            if (indexMap.containsKey(remainingElement)) {
                return new int[] { indexMap.get(remainingElement), i };
            }
            indexMap.put(currentElement, i);
        }
        return ans;
    }

    // leetcode - 1711
    // Count Good Meals
    public static int countPairs(int[] arr) {
        int mod = (int) 1e7;
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int num : arr) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= mod;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }
}
