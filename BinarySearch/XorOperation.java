package BinarySearch;

import java.util.Arrays;

public class XorOperation {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 7 };
        System.out.println("Actual Array is " + Arrays.toString(arr));
        operation(arr);
    }

    /*
     * For the first element, update arr[0] = arr[0] ^ arr[1].
     * For the last element, update arr[n-1] = arr[n-2] ^ arr[n-1].
     * For all other elements, update arr[i] = arr[i-1] ^ arr[i+1].
     */
    public static void operation(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[0] = arr[0] ^ arr[1];
            } else if (i == n - 1) {
                ans[n - 1] = arr[n - 2] ^ arr[n - 1];
            } else {
                ans[i] = arr[i - 1] ^ arr[i + 1];
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
