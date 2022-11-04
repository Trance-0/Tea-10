package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L345 {
    public String reverseVowels(String s) {
        Set<Character>target=new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[]arr=s.toCharArray();
        int left=0,right=arr.length-1;
        while(left<right){
            if(target.contains(arr[left])&&target.contains(arr[right])){
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            if(!target.contains(arr[left])){
                left++;
            }
            if(!target.contains(arr[right])){
                right--;
            }
        }
        return String.valueOf(arr);
    }
}
