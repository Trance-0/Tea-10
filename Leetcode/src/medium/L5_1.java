package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L5_1 {
    private int longestRoot = 0;
   private int longestLength = 0;
    private int halfLength=0;
    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            // test for aba pattern
            while ((i - (halfLength+1)) >= 0 && (i +(halfLength+1)) < s.length() && s.charAt(i - (halfLength+1)) == s.charAt(i + (halfLength+1))) {
                halfLength++;
            }

            if (halfLength*2+1 > longestLength) {
                longestRoot = i;
                longestLength = halfLength*2+1;
            }
            halfLength = 0;
            // test for abba pattern
            while ((i - halfLength ) >= 0 && (i + (halfLength+1) ) < s.length() && s.charAt(i - halfLength) == s.charAt(i + halfLength+1)) {
                halfLength++;
            }
            if (halfLength*2 > longestLength) {
                longestRoot = i;
                longestLength = halfLength*2;
            }
            halfLength = 0;
        }
            return s.substring(longestRoot-(longestLength-1)/2,longestRoot+(longestLength)/2+1);

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        L5_1 a=new L5_1();
        System.out.println(a.longestPalindrome(br.readLine()));
        System.out.println(a.longestLength);
        System.out.println(a.longestRoot);
    }
    // 64 68
}
