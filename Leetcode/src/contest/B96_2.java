package contest;
class B96_2{
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if(nums1.length!=nums2.length||k==0){
            return -1;
        }
        long result=0;
        long validate=0;
        for(int i=0;i<nums1.length;i++){
            int diff=nums1[i]-nums2[i];
            if(diff<0){
            diff=-diff;
            if(diff%k!=0){
                return -1;
            }
            validate-=diff/k;
            }else{
                if(diff%k!=0){
                    return -1;
                }
                validate+=diff/k;
                result+=diff/k;
            }
        }
        return validate==0? result:-1;
    }
}