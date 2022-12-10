package medium;
class L238 {
    public int[] productExceptSelf(int[] nums) {
        int rights=1;
        int[]lefts=new int[nums.length];
        int[]results=new int[nums.length];
        lefts[0]=1;
        rights=1;
        for(int i=1;i<nums.length;i++){
            lefts[i]=lefts[i-1]*nums[i-1];
        }
        for(int i=nums.length-1;i>=0;i--){

            results[i]=rights*lefts[i];
                        rights*=nums[i];
        }
        return results;
    }
}