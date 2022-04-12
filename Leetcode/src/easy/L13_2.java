package easy;
import java.util.HashMap;
import java.util.Map;
public class L13_2 {
    /*字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
    */
    public int romanToInt(String s) {
        int result=0;
        int prevAdd=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(getValue(s.charAt(i))>prevAdd){
                result-=prevAdd*2;
            }
            prevAdd=getValue(s.charAt(i));
            result+=getValue(s.charAt(i));
        }
        return result;
    }
    public int getValue (char key) {
        switch(key){
        case 'I':
            return 1;
        case 'V':
        return 5;
        case 'X':
        return 10;
        case'L':
        return 50;
        case'C':
        return 100;
        case'M':
        return 1000;
        case'D':
        return 500;
        default:
            return 0;
        }
    }
    //100 81
}
