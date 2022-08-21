package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L368_1 {
    // Largest Divisible Subset.
    // use two array, the first one is to store the length of the largest divisible
    // subset on the element.
    // the second array is to store the index of the previous element in the largest
    // divisible subset on the element.
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        // default value would be 1
        int[] chainSize = new int[nums.length];
        // default value would be -1
        int[] previousElement = new int[nums.length];
        // to ensure that every divisor is before the element
        Arrays.sort(nums);
        int indexOfLastElementInLongestChain = -1;
        int lengthOfLongestChain = 0;
        for (int i = 0; i < nums.length; i++) {
            chainSize[i] = 1;
            previousElement[i] = -1;
            for (int j = 0; j < i; j++) {
                // if divisable and the chain size is smaller than divisor+1
                if (nums[i] % nums[j] == 0 && chainSize[i] < chainSize[j] + 1) {
                    chainSize[i] = chainSize[j] + 1;
                    previousElement[i] = j;
                }
            }
            if (chainSize[i]>lengthOfLongestChain){
                lengthOfLongestChain=chainSize[i];
                indexOfLastElementInLongestChain=i;
            }
        }
        while (indexOfLastElementInLongestChain!=-1) {
            result.add(0,nums[indexOfLastElementInLongestChain]);
            indexOfLastElementInLongestChain=previousElement[indexOfLastElementInLongestChain];
        }
        return result;
    }
}
