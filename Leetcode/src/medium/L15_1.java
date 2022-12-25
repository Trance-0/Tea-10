package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        // If the nums can never meet the requirement for three sum
        if (nums.length < 3) {
            return result;
        }
        // Sort the nums to use dual pointers
        Arrays.sort(nums);
        // Start from the first element
        int i = 0;
        while (i < nums.length - 2) {
            // If the first element is greater than zero, it is impossible to add the three
            // elements to zero
            if (nums[i] > 0) {
                break;
            }
            // j is the second element
            int j = i + 1;
            // k is the greatest third element
            int k = nums.length - 1;
            // untill they meet
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (sum <= 0) {
                    // count to next unreapeated j
                    while (nums[j] == nums[j + 1] && j < k) {
                        j++;
                    }
                    j++;
                }
                if (sum >= 0) {
                    // count to next unreapeated k
                    while (nums[k] == nums[k - 1] && j < k) {
                        k--;
                    }
                    k--;
                }
            }
            // avoid repeated element
            while (nums[i] == nums[i + 1] && i < nums.length - 2) {
                i++;
            }
            // and count to next i
            i++;
        }
        return result;
    }
}
