package contest;
class Solution {
    public int differenceOfSum(int[] nums) {
          int elementSum=0,digitSum=0;
          for (int i:nums){
              elementSum+=i;
              while (i>10){
                  digitSum+=i%10;
                  i/=10;
              }
              digitSum+=i;
          }
          return elementSum-digitSum;
      }
  }