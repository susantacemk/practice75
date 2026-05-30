package BinarySearch;
public class FindPeak {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{6,5,4,3,2,3,2}));
    }
//  https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75
    public static int findPeakElement(int[] nums) {
        int n =nums.length;
        if(n==1){
            return n-1;
        }
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;

            // base case or edge case
            if(mid>0 && mid<n-1){
                if(nums[mid]>nums[mid-1] &&
                    nums[mid]>nums[mid+1]){
                        return mid;
                    }else if(nums[mid]< nums[mid-1]){
                        // right side
                        high=mid-1;
                    }else if(nums[mid]<nums[mid+1]){
                        // left side
                        low=mid+1;
                    }
            }
            else if(mid==0){
                // just check its next element
                if(nums[mid]>nums[mid+1]){
                    return mid;
                }else{
                    return mid+1;
                }
            }
            else if(mid==n-1){
                // just check previous element
                if(nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    return mid-1;
                }
            }
        }
        return -1;
    }
}