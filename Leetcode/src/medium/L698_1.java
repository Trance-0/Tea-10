package medium;

import java.util.stream.IntStream;

class L698_1{
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // firts test if we could partition sum into given group
        int sum =IntStream.of(nums).sum();
        // then set a array for visit check in dfs
        // dfs for subset
        return k!=0&& sum%k==0&&canPartition(nums, new boolean[nums.length], 0, k, 0,sum/k);
    }
    public boolean canPartition(int[] nums, boolean[] visited, int startIndex, int k, int currentSum,int target){
        // if meet the criteria return true
        if(k==1){
            return true;
        }
        // if get first subset, test for next k-1 subet
        if (currentSum==target){
            return canPartition(nums, visited, 0, k-1, 0, target);
        }
        // iterate the other unvisited elements in array and test if they meet the criteria.
        for (int i=startIndex;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                if (canPartition(nums, visited, i+1, k, currentSum+nums[i], target)){
                    return true;
                }
                visited[i]=false;
            }

        }
        return false;
    }
}