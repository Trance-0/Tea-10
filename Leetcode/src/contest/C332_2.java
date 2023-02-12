package contest;

import java.util.Arrays;

public class C332_2 {
         // find the smallest value greq than target
    private int lowerBound(int start, int end, int target, int[]nums){
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
    // find the largest value less than target
    private int upperBound(int start, int end, int target, int[]nums){
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start= mid + 1;
            } else {
               end = mid;
            }
        }
        return start;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long result=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int idx=0;idx<n;idx++){    
            result+=(upperBound(idx+1,n,upper-nums[idx],nums)-lowerBound(idx+1,n,lower-nums[idx],nums));
        }
        return result;
    }
    public static void main(String[] args) {
        C332_2 a = new C332_2();
        a.countFairPairs(new int[] {6,9,4,2,7,5,10,3}, 13, 13);
    }
}