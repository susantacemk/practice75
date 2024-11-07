package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEating(new int[]{3,6,7,11}, 8));
    }
    // Brute force approach
    public static int minEatingSpeed(int[] piles, int h) {
        int max=maximum(piles);
        for(int i=1;i<=max;i++){
            int requiredhour=f(piles,i);
            if(requiredhour<h){
                return i;
            }
        }
        return -1;
    }

    // Optimized approach
    public static int minEating(int[]piles, int h){
        int low=1;
        int high=maximum(piles);
        while(low<=high){
            int mid=(low+high)/2;
            if(f(piles, mid)<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int maximum(int[]piles){
        int max=piles[0];
        for(int i=1;i<piles.length;i++){
            if(max<piles[i]){
                max=piles[i];
            }
        }
        return max;
    }

    private static int f(int[]piles, int hour){
        int totalHour=0;
        for(int i=0;i<piles.length;i++){
            totalHour+=Math.ceil((double)piles[i]/(double)hour);
        }
        return totalHour;
    }

}
