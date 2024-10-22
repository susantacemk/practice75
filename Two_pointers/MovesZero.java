package Two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MovesZero {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of element::");
        int n = Integer.parseInt(bf.readLine());
        // array declaration
        int[] arr = new int[n];
        System.out.print("Enter the array value one by one::");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        moveZeroes(arr);
        System.out.println("After Moves Zero the array will be::" + Arrays.toString(arr));
    }

    // Time Complexity = O(n)
    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // swap left and right pointer array value
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
