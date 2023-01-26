package contest;

import java.util.HashSet;

public class C329_3 {
    public boolean makeStringsEqual(String s, String target) {
        boolean hoit=false,hois=false;
        if(s.compareTo(target)==0){
            return true;
        }
        for(int i=0;i<s.length();i++){
            if(target.charAt(i)=='1'){
               hoit=true;
            }
            if(s.charAt(i)=='1'){
                hois=true;
            }
        }
        return hoit&&hois;
    }
}
