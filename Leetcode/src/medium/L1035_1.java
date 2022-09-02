package medium;

public class L1035_1 {
    // dynamic programing to find the max uncrossed lines
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1.length<nums2.length){
            return maxUncrossedLines(nums2, nums1);
        }
        int[] maxUncrossedLinesOnIndex=new int[nums2.length+1];
        for(int i=0;i<nums1.length;i++){
            int previous=0;
            // this part is really tricky, use num2 as base
            for(int j=0;j<nums2.length;j++){
                int current=maxUncrossedLinesOnIndex[j+1];
                if(nums1[i]==nums2[j]){
                    maxUncrossedLinesOnIndex[j+1]=previous+1;
                }else{
                    maxUncrossedLinesOnIndex[j+1]=Math.max(maxUncrossedLinesOnIndex[j],maxUncrossedLinesOnIndex[j+1]);
                }
                previous=current;
            }
        }
        return maxUncrossedLinesOnIndex[nums2.length];
    }
}
