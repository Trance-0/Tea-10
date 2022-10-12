package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L820_2 {
    public int minimumLengthEncoding(String[] words) {
       Set<String>wordSet=new HashSet<String>(Arrays.asList(words));
          // then check if the latter is already stored before.
        for (String temp:words){
            // start from each # search for substring indexof('#')-words[i].length
           for(int i=1;i<temp.length();i++){
            wordSet.remove(temp.substring(i));
            }
        }
        int count=0;
        for(String i:wordSet){
            count +=i.length()+1;
        }
        return count;

    }
}
