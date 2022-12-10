package medium;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int low=0,high=nums.length-1;
            while(low<high){
                if(nums[low]+nums[high]>-nums[i]){
                    low++;
                }else if(nums[low]+nums[high]<-nums[i]){
                    high--;
                }else{
                    if(i==low||i==high){
                        continue;
                    }
                    result.add(Arrays.asList(nums[low],nums[high],nums[i]));
                }
            }
        }
        return result;
    }
}
