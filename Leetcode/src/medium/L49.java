package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,LinkedList<String>> map=new HashMap<String,LinkedList<String>>();
        for(String i:strs){
            char[]test=i.toCharArray();
            Arrays.sort(test);
            if(map.containsKey(String.valueOf(test))){
                map.get(String.valueOf(test)).add(i);
            }else{
                LinkedList<String> newList=new LinkedList<String>();
                newList.add(i);
                map.put(String.valueOf(test),newList);
            }
        }
        List<List<String>> result=new LinkedList<List<String>>();
        for(String i:map.keySet()){
            result.add(map.get(i));
        }
        return result;
    }
}
