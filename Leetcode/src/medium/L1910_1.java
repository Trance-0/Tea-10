package medium;

public class L1910_1 {
    public String removeOccurrences(String s, String part) {
        while (s.indexOf(part)>=0){
            s=s.substring(0, s.indexOf(part))+s.substring(s.indexOf(part)+part.length());
        }
        return s;
    }
}
