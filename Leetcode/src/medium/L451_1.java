package medium;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L451_1 {
    public String frequencySort(String s) {
        Map<Character,Integer> frequencyMap=new HashMap<Character,Integer>();
        // check frequency of each character
        for (char i :s.toCharArray()){
            frequencyMap.put(i,frequencyMap.getOrDefault(i, 0)+1);
        }
        //bucket sort
        List<Character>[]buckets=new LinkedList[s.length()+1];
        for(char i: frequencyMap.keySet()){
            if (buckets[frequencyMap.get(i)]==null) buckets[frequencyMap.get(i)]=new LinkedList<Character>();
            buckets[frequencyMap.get(i)].add(i);
        }
        

        StringBuilder sb=new StringBuilder();
        for (int i=s.length();i>=0;i--){
            if (buckets[i]==null) continue;
            for (char j :buckets[i])
                for(int k=0;k<i;k++)
                    sb.append(j);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        L451_1 test=new L451_1();
        System.out.println(test.frequencySort("tree"));
    }
}
