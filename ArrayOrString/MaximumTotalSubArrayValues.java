public class MaximumTotalSubArrayValues {
    public static void main(String[] args) {
        System.out.println(new Solution().maxTotalValue(new int[] { 1, 3, 2 }, 2));
    }

}

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long result;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (int item : nums) {
            max = Math.max(max, item);
            min = Math.min(min, item);
        }
        result = (long) k * (max - min);
        return result;
    }
}
