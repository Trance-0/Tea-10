import java.time.LocalDate;

public class L915_1 {
    /*
     * Every element in left is less than or equal to every element in right.
     * left and right are non-empty.
     * left has the smallest possible size.
     */
    public int partitionDisjoint(int[] nums) {
int leftMax=nums[0],cut=0,globalMax=leftMax;
for(int i=1;i<nums.length;i++){
    if(leftMax>nums[i]){
        leftMax=globalMax;
        cut=i;
    }else{
        globalMax=Math.max(globalMax,nums[i]);
    }
}
return cut+1;
    }
}
