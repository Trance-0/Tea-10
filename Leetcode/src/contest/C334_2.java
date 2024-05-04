package contest;

public class C334_2 {
    public int[] divisibilityArray(String word, int m) {
        int n=word.length();
        int[] result=new int[n];
        long carry=0;
        for(int i=0;i<n;i++){
            carry=0;
            for(int j=0;j<i;j++){
                carry=(carry%m)*10+(word.charAt(j)-'0');
            }
            result[i]=carry==0?1:0;
        }
        return result;
    }
}
