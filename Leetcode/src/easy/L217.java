package easy;

import java.util.HashSet;

public class L217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:nums){
            if(!set.add(i)){
return true;
            }
            }
        return false;
    }
}
