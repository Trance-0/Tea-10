package contest;

public class C334_1 {
    public int[] leftRigthDifference(int[] nums) {
        int[]leftSum=new int[nums.length];
        int[]rightSum=new int[nums.length];
        int[]result=new int[nums.length];
        int left=0,right=0;
        for(int i=1;i<=nums.length;i++){
            leftSum[i-1]=left;
            rightSum[nums.length-i]=right;
            left+=nums[i-1];
            right+=nums[nums.length-i];
        }
        for(int i=0;i<nums.length;i++){
            result[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[]num={10,4,8,3};
        C334_1 a=new C334_1();
        a.leftRigthDifference(num);
    }
}
