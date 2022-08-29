package medium;

import java.util.HashSet;
import java.util.Set;

public class L898_1 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> currentSearch=new HashSet<Integer>();
        Set<Integer> uniqureIntegers=new HashSet<Integer>();
        Set<Integer> previousSearch=new HashSet<Integer>();
        for(int i:arr){
            currentSearch=new HashSet<Integer>();
            // this line is used to ensure that OR operation will not be empty;
            previousSearch.add(0);
            for(int j:previousSearch){
                currentSearch.add(i|j);
                uniqureIntegers.add(i|j);
            }
            previousSearch=currentSearch;
        }
        return uniqureIntegers.size();
    }
    public static void main(String[] args) {
        System.out.println(1|2|1);
    }
}
