package contest;

public class B95_3 {
    public int xorBeauty(int[] nums) {
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
}
