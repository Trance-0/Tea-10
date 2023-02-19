package contest;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class C333_3 {
    public int squareFreeSubsets(int[] nums) {
        int n=nums.length,result=0,M=1000000007;
        HashMap<Integer,LinkedList<Integer>>map=new HashMap<Integer,LinkedList<Integer>>();
        LinkedList<Integer>temp=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            temp= map.getOrDefault(nums[i],new LinkedList<>());
            temp.add(i);
            map.put(nums[i], temp);
        }
        for(int i:map.keySet()){
            if(i/Math.sqrt(i)==i){
                result=result&M+n%M;
            }
            if(map.get(i).size()>1){
                temp=map.get(i);
                Collections.sort(temp);
                for(int start=0;start<temp.size();start++){
                    for(int end=start;end<temp.size();end++){
                        result+=result%M+(n-(end-start))%M;
                    }
                }
            }
        }
        return result;
    }
}
