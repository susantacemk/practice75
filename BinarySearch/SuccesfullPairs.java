package BinarySearch;

import java.util.Arrays;

public class SuccesfullPairs {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairsOptimize(new int[]{3,1,2}, new int[]{8,5,8}, 16)));
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) { // O(n*m)
        int n=spells.length;
        int m=potions.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int countPair=0;
            for(int j=0;j<m;j++){
                if(spells[i]*potions[j]>=success){
                    countPair+=1;
                }
            }
            ans[i]=countPair;
        }
        return ans;
    }


    public static int[] successfulPairsOptimize(int[]spells,int[]potions,long success){
        Arrays.sort(potions);
    int[] result = new int[spells.length];

    for (int i = 0; i < spells.length; ++i) {
      long successFactor = (success + spells[i] - 1) / spells[i];
      int startPosition = binarySearch(potions, successFactor);
      result[i] = potions.length - startPosition;
    }
    return result;
}

  private static int binarySearch(int[] potions, long successFactor) {
    int left = 0, right = potions.length;

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (potions[middle] < successFactor)
        left = middle + 1;
      else
        right = middle;
    }
    return right;
    }
}
