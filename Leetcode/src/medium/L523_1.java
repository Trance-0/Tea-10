package medium;

import java.util.HashMap;
import java.util.Map;

class L523_1{
    public boolean checkSubarraySum(int[] nums, int k) {
        // find continuous sub array with sum%k==0
        // the key is the value of running module where the value is index of continuous sum
        Map<Integer,Integer> history=new HashMap<Integer,Integer>(){{put(0,-1);}};
        int continuousSum=0;
        for(int i=0;i<nums.length;i++){
            continuousSum+=nums[i];
            // avoid module by 0
            if(k!=0){
                continuousSum=continuousSum%k;
            }
            // if the module value is gained before and the distance between the two value is greater than 1.
            if(i-history.getOrDefault(continuousSum,i)>1 ){
                return true;
            }
            // do not overwrite the module value stored before
            if(history.get(continuousSum)==null){
            history.put(continuousSum,i);
            }
        }
        return false;
    }
}