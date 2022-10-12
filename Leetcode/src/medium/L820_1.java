package medium;

import java.util.Arrays;
import java.util.Comparator;

public class L820_1 {
    public int minimumLengthEncoding(String[] words) {
        StringBuilder sb=new StringBuilder();
        // sort the array from longest to shortest
        Arrays.sort(words,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o2.length()-o1.length();
            }
            
        });
        // then check if the latter is already stored before.
        for (int i=0;i<words.length;i++){
            // start from each # search for substring indexof('#')-words[i].length
            if(sb.toString().contains(words[i]+"#")){
                continue;
            }
            sb.append(words[i]);
                sb.append("#");
        }
        return sb.length();
    }
}
