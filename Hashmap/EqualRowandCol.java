package Hashmap;

import java.util.HashMap;
// https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
public class EqualRowandCol {
    public static void main(String[] args) {
        int[][] grid1 = {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 }
        };
        System.out.println(equalPairs(grid1));

        int[][] grid2={
            {3,1,2,2},
            {1,4,4,5},
            {2,4,2,2},
            {2,4,2,2}
        };
        System.out.println(equalPairs(grid2));
        System.out.println(equalPairs(new int[][]{{11,1},{1,11}}));
        System.out.println(equalPairs(new int[][]{
            {3,1,2,2},
            {1,4,4,4},
            {2,4,2,2},
            {2,5,2,2}
        }));
    }

    public static int equalPairs(int[][] grid) {
       // Initialize a map for mapping all
        // column with their frequency of
        // occurrence.
        HashMap<String, Integer> unmap
            = new HashMap<String, Integer>();

        // Iterate over all rows
        for (int i = 0; i < grid.length; i++) {

            // Initialize an empty string s = ""
            String s = "";

            // Keep appending all the element
            // into string s
            for (int j = 0; j < grid[0].length; j++) {
                s += Integer.toString(grid[i][j]);
                s += "*";
            }

            // Increment the frequency count of
            // string s in map
            if (unmap.get(s) == null) {
                unmap.put(s, 1);
            }
            else {
                unmap.put(s, unmap.get(s) + 1);
            }
        }

        // Initialize a result variable for
        // storing the number of pair such that
        // row and column are equal
        int result = 0;

        // Iterate over all the columns
        for (int j = 0; j < grid[0].length; j++) {

            // Initialize an empty string s = ""
            String s = "";

            // Keep appending all the element
            // into string s
            for (int i = 0; i < grid.length; i++) {
                s += Integer.toString(grid[i][j]);
                s += "*";
            }

            // The condition check is required
            // for cases like the below
            // { 3,2,1},
            // { 1,7,6},
            // { 2,7,7},
            if (unmap.containsKey(s)) {
               result += unmap.get(s);
            }  
        }

        // Return the result
        return result;
    }
}
