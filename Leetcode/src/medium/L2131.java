package medium;

import java.util.HashSet;
import java.util.Set;

import javax.swing.RepaintManager;

public class L2131 {
    /*
     * You are given an array of strings words. Each element of words
     * consists of two lowercase English letters.
     * Create the longest possible palindrome by selecting some elements
     * from words and concatenating them in any order. Each element can
     * be selected at most once.
     * Return the length of the longest palindrome that you can create.
     * If it is impossible to create any palindrome, return 0.
     * A palindrome is a string that reads the same forward and backward.
     */
    public int longestPalindrome(String[] words) {
        // the word looks like this ab ... ab aa ba ... ba
        // cheating table
        int[][] record = new int[26][26];
        int repeaterCount = 0;
        // for each word in words
        for (String i : words) {
            char[] temp = i.toCharArray();
            temp[0] -= 97;
            temp[1] -= 97;
            // test if i reverse is in record
            if (record[temp[1]][temp[0]] > 0) {
                record[temp[1]][temp[0]]--;
                // add word pairs
                repeaterCount +=2;
            } else {
                // add i to records
                record[temp[0]][temp[1]]++;
            }
        }
        // find core
        for(int i=0;i<26;i++){
            if(record[i][i]>0){
                repeaterCount++;
                break;
            }
        }
        return repeaterCount * 2;
    }
}
