package contest;

import java.util.HashSet;

public class B98_3 {
    public int minImpossibleOR(int[] nums) {
        HashSet<Integer>set=new HashSet<Integer>();
        for(int i:nums){
            set.add(i);
        }
        int test=1;
        for(int i=0;i<9;i++){
            if(!set.contains(test)){
                break;
            }
            test=test<<1;
        }
        return test;
    }
    public static void main(String[] args) {
        B98_3 a=new B98_3();
        int[]test={7,3,9,5,1,2,4};
        System.out.println(a.minImpossibleOR(test));
     }
}
