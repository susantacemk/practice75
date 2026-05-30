package Two_pointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Most Water contained " + maxAreaOfWater(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    // Brute force approach - Time O(n^2)
    // But TLE are happened when constarints 2 <= n <= 10^5
    public static int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1 + 1; j < n; j++) {
                int weight = (j - i);
                int heights = Math.min(height[i], height[j]);
                int mostWater = weight * heights;
                maxWater = Math.max(maxWater, mostWater);
            }
        }
        return maxWater;
    }

    // optimal Approach O(logn)

    public static int maxAreaOfWater(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int weight = (right - left);
            int heights = Math.min(height[left], height[right]);
            int mostWater = weight * heights;
            maxWater = Math.max(maxWater, mostWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

}
