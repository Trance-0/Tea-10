package easy;
import java.util.HashMap;
import java.util.Map;
public class L13_1 {
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
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))>prevAdd){
                result-=prevAdd*2;
            }
            prevAdd=map.get(s.charAt(i));
            result+=map.get(s.charAt(i));
        }
        return result;
    }
    //63 39
}
