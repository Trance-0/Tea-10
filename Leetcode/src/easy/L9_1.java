package easy;

import java.util.*;

public class L9_1 {
    public boolean isPalindrome(int x) {
        String mx=Integer.toString(x);
        for (int i=0;i<mx.length()/2;i++){
            if(mx.charAt(i)!=mx.charAt(mx.length()-1-i)){
                return false;
            }
        }
    return true;
    }
    //72 69
}