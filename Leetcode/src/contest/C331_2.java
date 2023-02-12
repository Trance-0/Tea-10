package contest;

import java.util.*;
import java.util.HashSet;

public class C331_2 {
    class Solution {
        private final char[] vowels={'a','e','i','o','u'};
        public int[] vowelStrings(String[] words, int[][] queries) {
            int[] result=new int[queries.length];
            int[] prefixSum=new int[words.length+1];
            HashSet<Character> VSet = new HashSet<Character>();
            for(char i:vowels){
                VSet.add(i);
            }
            int count=0;
            for(int i=0;i<words.length;i++){
                if(VSet.contains(words[i].charAt(0))&&VSet.contains(words[i].charAt(words[i].length()-1))){
                    count++;
                }
                prefixSum[i+1]=count;
            }
            for(int i=0;i<queries.length;i++){
                result[i]=prefixSum[queries[i][1]]-prefixSum[queries[i][0]-1];
            }
            return result;
        }
    }
}
