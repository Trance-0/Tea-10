package medium;

import java.util.Arrays;

/* 
 * Let the function f(s) be the frequency of the lexicographically smallest character 
 * in a non-empty string s. For example, if s = "dcce" then f(s) = 2 because the 
 * lexicographically smallest character is 'c', which has a frequency of 2.
 * You are given an array of strings words and another array of query strings 
 * queries. For each query queries[i], count the number of words in words such 
 * that f(queries[i]) < f(W) for each W in words.
 * Return an integer array answer, where each answer[i] is the answer to the ith query.
 */
public class L1170_1 {
    private int[]swap;
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // this is used to display results
        int[] result = new int[queries.length];
        // count frequency of the lexicographically smallest character in words
        // eg. 1, 2, 4, 2, 2
        int[] wordsLex=new int[11];
        for (int i=0;i<words.length;i++){
            wordsLex[lexMin(words[i])]++;
        }
        // set for sum
        int sum =0;
        for (int i=0;i<wordsLex.length;i++){
            sum +=wordsLex[i];
            wordsLex[i]=sum;
        }
        for(int i=0;i<queries.length;i++){
            result[i]=sum-wordsLex[lexMin(queries[i])];
        }
        return result;
    }
    private int lexMin(String test){
        swap=new int[26];
        for (char i:test.toCharArray()){
            swap[i-97]++;
        }
        for (int i:swap){
            if (i!=0) return i;
        }
        return -1;
    }
}
