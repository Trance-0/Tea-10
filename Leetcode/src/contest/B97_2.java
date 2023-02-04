package contest;

public class B97_2 {
    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            boolean[] ban=new boolean[n+1];
            for(int i=0;i<banned.length;i++){
                if(banned[i]<=n){
                    ban[banned[i]]=true;
                }
            }
            int curSum=0,count=0;
            for(int i=1;i<=n;i++){
                if(ban[i]==false){
                    curSum+=i;
                    count++;
                }
                if(curSum>maxSum){
                    count--;
                    break;
                }
            }
            return count;
        }
    }
}
