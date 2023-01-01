package easy;

import java.util.HashMap;
import java.util.HashSet;

class L290 {
    public boolean wordPattern(String pattern, String s) {
        HashSet<String>assignedValue=new HashSet<String>();
        HashMap<Character, String> map = new HashMap<Character, String>();
        String[] sequence = s.split(" ");
        if(sequence.length!=pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if(assignedValue.contains(sequence[i])){
                    return false;
                }
                map.put(pattern.charAt(i), sequence[i]);
                assignedValue.add(sequence[i]);
                continue;
            }
            if (sequence[i].compareTo(map.get(pattern.charAt(i))) != 0) {
                return false;
            }
        }
        return true;
    }
}