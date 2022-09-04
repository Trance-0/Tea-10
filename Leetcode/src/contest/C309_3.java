package contest;

public class C309_3 {
    public int longestNiceSubarray(int[] nums) {
        //binary search
        int i=0,j=nums.length;

        while(i<j){
            int mid=(i+j)/2;
            if(findArrayin(nums,mid)){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }

    private boolean findArrayin(int[] nums, int mid) {
        for(int i=0;i<nums.length-mid;i++){
            int sum=0;
            boolean failed=false;
            for(int j=i;j<i+mid;j++){
                if((nums[j]&sum)>0){
                    failed=true;
                    break;
                }
                sum=nums[j]|sum;
            }
            if(failed){
                continue;
            }
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        C309_3 a=new C309_3();
        int result=a.longestNiceSubarray(new int[]{536870399,890391654});
        System.out.println(result);
    }
}
