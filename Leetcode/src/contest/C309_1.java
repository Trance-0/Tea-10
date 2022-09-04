package contest;

public class C309_1 {
    public boolean checkDistances(String s, int[] distance) {
        boolean[] isChecked =new boolean[26];
        for(int i=0;i<s.length();i++){
            if(!isChecked[s.charAt(i)-97]){
                continue;
            }
            if(i+distance[s.charAt(i)-97]+1>=s.length()||s.charAt(i+distance[s.charAt(i)-97]+1)!=s.charAt(i)){
                return false;
            }
                isChecked[s.charAt(i)-97]=true;
        }
        return true;
    }
}
