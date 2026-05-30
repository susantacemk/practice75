package BinarySearch;

public class Search {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 6, 8, 9, 23, 45, 56, 75 };
        int target = 23;
        System.out.println(find(arr, target));
    }

    private static boolean find(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = j - (j - i) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}