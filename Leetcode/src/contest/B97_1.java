package contest;

import java.util.LinkedList;

public class B97_1 {
    class Solution {
        public int[] separateDigits(int[] nums) {
            int n=nums.length,idx=0;
            LinkedList<Character>buffer=new LinkedList<Character>();
            for(int i=0;i<n;i++){
                String temp=Integer.toString(nums[i]);
                for(int j=0;j<temp.length();j++){
                    buffer.add(temp.charAt(j));
                }
            }  
            int[]result=new int[buffer.size()];
            for(char i:buffer){
                result[idx]=i-'0';
                idx++;
            }
            return result;
        }
    }
}
