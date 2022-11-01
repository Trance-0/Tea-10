package medium;

public class L926 {
    // This is a classic example of dynamic programming.

    /*
     * A binary string is monotone increasing if it consists of some number of 0's (possibly none), 
     * followed by some number of 1's (also possibly none).
     * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
     * Return the minimum number of flips to make s monotone increasing.
     */

     /*
      * Example 2:
      * Input: s = "010110"
      * Output: 2
      * Explanation: We flip to get 011111, or alternatively 000111.
      */
    public int minFlipsMonoIncr(String s) {
        int flipCounts=0,oneCounts=0;
        for(char i :s.toCharArray()){
            //record the number of ones and zeros to flip
            if(i==48){
                if(oneCounts==0){
                    continue;
                }
                flipCounts++;
            }else{
                oneCounts++;
            }
            // if fliped zeros exceeds fliped ones.
            if(flipCounts>oneCounts){
                flipCounts=oneCounts;
            }
        }
        return flipCounts;
    }
}
