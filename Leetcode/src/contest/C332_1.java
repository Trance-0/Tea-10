package contest;

public class C332_1 {
    public long findTheArrayConcVal(int[] nums) {
        long result=0;
        for (int i=0;i<nums.length/2-1;i++){
            result+=Long.parseLong(Integer.toString(nums[i])+Integer.toString(nums[nums.length-i-1]));
        }
        if(nums.length%2==1){
            result+=Long.parseLong(Integer.toString(nums.length/2));
        }
        return result;
    }
}
