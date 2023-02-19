package contest;

import java.util.LinkedList;

public class B98_4 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n=nums1.length,p=1;
        boolean[] xor=new boolean[n];
        LinkedList<Long>sum=new LinkedList<Long>();
        for(int[]i:queries){
            if(i[0]==1){
                xor[i[1]]=!xor[i[1]];
                xor[i[2]]=!xor[i[2]];
            }else if(i[0]==2){
                p*=i[1];
            }else{
                long cursum=0;
                boolean flip=xor[0];
                for(int j=0;j<n;j++){
                    flip=xor[j]?flip:!flip;
                    if(flip){
                        nums1[j]=nums1[j]==0?1:0;
                    }
                    nums2[j]=nums2[j]+p*nums1[j];
                    cursum+=nums2[j];
                }
                sum.add(cursum);
            }
        }
        long[]result=new long[10];
        return result;
    }

    public static void main(String[] args) {
        B98_3 a=new B98_3();
        
     }
}
