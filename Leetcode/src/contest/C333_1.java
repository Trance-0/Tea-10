package contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class C333_1 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        for(int[]i:nums1){
            map.put(i[0], i[1]);
        }
        for (int[] i:nums2){
            map.put(i[0],  map.getOrDefault(i[0], 0)+i[1]);
        }
        int[][]result=new int[map.size()][2];
        int idx=0;
        for(int i:map.keySet()){
            result[idx]=new int[]{i,map.get(i)};
            idx++;
        }
        Arrays.sort(result,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0]-o2[0];
            }
            
        });
        return result ;
        
    }
}
