public class Solution {
    // I got the solution from thekalyan001, the reverse method really fansinates me.
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        //reverse the first part of array
        reverse(nums,0,nums.length-k-1);
        //reverse second part of array
        reverse(nums,nums.length-k,nums.length-1);
        //reverse entire array
        reverse(nums,0,nums.length-1);
    }
    public void reverse(int[] nums,int begin, int end){
        int swap=0;
        for(int i=0;i<(end-begin+1)/2;i++){
            swap=nums[begin+i];
            nums[begin+i]=nums[end-i];
            nums[end-i]=swap;
        }
    }

    public static void main(String[] args) {
        String temp="lalallalalla lala     alalal ";
        String[] split=temp.split("\\s+");
        for(String x: split){
            System.out.println(x);
        }
        System.out.println(split.length);
        // for(int[]num:array){
        //     for(int i:num){
        //         sum+=i;
        //     }
        // }
    }
}