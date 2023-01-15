package contest;

import java.util.HashMap;

public class B328_3 {
    public long countGood(int[] nums, int k) {
        int pairOfArray = 0;
        long arrayCount = 0;
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        int i = 0, j = -1;
        while (j < nums.length-1) {
            // if array meet, shrink array till i does not meet
            if (pairOfArray >= k) {
                int odi = i;
                while (pairOfArray >= k) {
                    int newCount = elementCount.get(nums[i]);
                    pairOfArray -= newCount-1;
                    elementCount.put(nums[i],newCount-1);
                    i++;
                }
                arrayCount += i-odi;
            } else {
                // if array does not meet, increase j till meet
                j++;
                int newCount = elementCount.getOrDefault(nums[j], 0);
                pairOfArray += newCount;
                elementCount.put(nums[j], newCount + 1);
                if(pairOfArray>=k){
                    arrayCount+=nums.length-j;
                }
            }
        }
        return arrayCount;
    }
    public static void main(String[] args) {
        B328_3 a=new B328_3();
        int[] good={2,1,3,1,2,2,3,3,2,2,1,1,1,3,1};
        long result=a.countGood(good, 11);
        //         int[] good={1,1,1,1,1};
        // long result=a.countGood(good, 10);

        // int[] good={        3,1,4,3,2,2,4};
        // long result=a.countGood(good, 2);
        System.out.println(result);
    }
}
