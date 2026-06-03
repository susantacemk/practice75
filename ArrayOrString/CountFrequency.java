import java.util.ArrayList;

public class CountFrequency {

    /*
     * Input: arr[] = [1, 2, 1, 3, 1, 2, 3], queries[][] = [[0, 4, 1], [2, 5, 2],
     * [1, 6, 3], [0, 6, 5]]
     * Output: [3, 1, 2, 0]
     * Explanation:
     * query [0, 4, 1] -> Subarray = [1, 2, 1, 3, 1], 1 appears 3 times
     * query [2, 5, 2] -> Subarray = [1, 3, 1, 2], 2 appears 1 time
     * query [1, 6, 3] -> Subarray = [2, 1, 3, 1, 2, 3] 3 appears 2 times
     * query [0, 6, 5] -> Subarray = [1, 2, 1, 3, 1, 2, 3], 5 appears 0 times
     */
    public static void main(String[] args) {
        // arr[] and query
        int[] arr = new int[] { 1, 2, 1, 3, 1, 2, 3 };
        int[][] queries;
        queries = new int[][] { { 0, 4, 1 }, { 2, 5, 2 },
                { 1, 6, 3 }, { 0, 6, 5 } };
        System.out.println((count(arr, queries)));
    }

    public static ArrayList<Integer> count(int[] arr, int[][] queries) {
        // create one answer array
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            ans.add(helperCount(arr, l, r, x));
        }
        return ans;
    }

    public static int helperCount(int[] arr, int l, int r, int x) {
        // l == lower bound
        // r = upper bound
        // x = target element
        // inclusive
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] == x) {
                cnt++;
            }
        }
        return cnt;
    }

    public static ArrayList<Integer> countOptimized(int[] arr, int[][] queries) {
        // Precompute max element
        int maxVal = 0;
        for (int x : arr)
            maxVal = Math.max(maxVal, x);

        // Build prefix sum for each value: prefix[val][i] = count of val in arr[0..i]
        int[][] prefix = new int[maxVal + 1][arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int v = 0; v <= maxVal; v++) {
                prefix[v][i + 1] = prefix[v][i] + (arr[i] == v ? 1 : 0);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0], r = query[1], x = query[2];
            ans.add(x <= maxVal ? prefix[x][r + 1] - prefix[x][l] : 0);
        }
        return ans;
    }
}
