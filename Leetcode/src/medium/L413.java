package medium;

public class L413 {
    public int numberOfArithmeticSlices(int[] nums) {
        // number of arithmetic slices
        int slices = 0;
        for (int i = 2, prev = 0; i < nums.length; i++){
            // prev is number of arithmetic slices before i, in the case, 
            // where 1,2,3,4 is found, the first array 1,2,3,4 shall be 
            // recorded and 1,2,3 2,3,4 shall also be added to sliced.
            slices += (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])  ? ++prev : (prev = 0);
        }
        return slices;
    }
}
