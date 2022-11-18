package medium;

import java.util.HashSet;

class L6234 {
    public int subarrayLCM(int[] nums, int k) {
        if (nums.length == 1 && k != nums[0]) {
            return 0;
        }
        HashSet<Integer> common = new HashSet<Integer>();
        for (int i = 1; i <= k; i++) {
            if (k % i == 0) {
                common.add(i);
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int buffer = 1;
            int count=0;
            if (common.contains(nums[i])) {
                for (int j = i; j < nums.length; j++) {
                    if (common.contains(nums[j])) {
                        if ((buffer * nums[j]) >= k) {
                            result+=count;
                            count=1;
                        }else {
                            buffer *= nums[j];
                            count++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}