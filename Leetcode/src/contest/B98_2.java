package contest;

import java.util.Arrays;
import java.util.HashMap;

public class B98_2 {
    public int minimizeSum(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> freq=new HashMap<Integer,Integer>();
        for (int i:nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
            // case when we can make them equal
            if(freq.get(i)==n-2){
                return 0;
            }
        }
        Arrays.sort(nums);
        int changeFirst=nums[n-1]-nums[2];
        int changeLast=nums[n-3]-nums[0];
        int changeFirstAndLast=nums[n-2]-nums[1];
        return Math.min(changeFirst ,Math.min(changeFirstAndLast,changeLast));
    }
    public static void main(String[] args) {
        B98_2 a=new B98_2();
        
     }
}
