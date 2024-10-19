public class FindThreeIndex {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min1)
                min1 = n;
            else if (n <= min2)
                min2 = n;
            else
                return true;
        }
        return false;
    }
}
