package contest;
class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        for(int i=0;i<words.length/2+1;i++){
            // i is the offset
            if(words[(startIndex+i)%words.length].compareTo(target)==0||words[(startIndex-i+words.length)%words.length].compareTo(target)==0){
                return i;
            }
        }
        return -1;
    }
}