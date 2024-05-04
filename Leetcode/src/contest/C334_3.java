package contest;

import java.util.Arrays;

public class C334_3 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int result=0,i=nums.length-1,j=nums.length-1,start=nums.length<<1;
        while(i>=0&&j>start){
            if((nums[i]<<1)<=nums[j]){
                // for 32 e:26 case
                result+=2;
                i--;
                j--;
            }else{
                i--;
            }
        }
        // int backResult=0;
        // i=0;
        // j=0;
        // start=0;
        // while(i<nums.length&&j<start){
        //     if((nums[j]<<1)<=nums[i]){
        //         // for 32 e:26 case
        //         start=Math.min(start, i);
        //         result+=2;
        //         i++;
        //         j++;
        //     }else{
        //         i++;
        //     }
        // }
        return result;
    }
    public static void main(String[] args) {
        // int[] nums={42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40};
        int[] nums={9,2,5,4};
        C334_3 a=new C334_3();
        a.maxNumOfMarkedIndices(nums);
    }
}
