package medium;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<LinkedList<Integer>> result=new LinkedList<LinkedList<Integer>>();
        Arrays.sort(nums);
        for(int i:nums){
            int low=0,high=nums.length-1;
            while(low<high){
                if(nums[low]+nums[high]>-i){
                    low++;
                }else if(nums[low]+nums[high]>-i){
                    high--;
                }else{
                    result.add(Arrays.asList({nums[low],nums[high],nums}));
                }
            }
        }
    }
}
