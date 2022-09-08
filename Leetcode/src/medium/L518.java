package medium;

public class L518 {
    // knapsack problem, use dynamic programing
    public int change(int amount, int[] coins) {
        // dp array
        int[] methodCount=new int[amount+1];
        // when coin value=amount, there is one way.
        methodCount[0]=1;
        for(int i : coins){
            for(int j=i;j<amount+1;j++){
                methodCount[j]+=methodCount[j-i];
            }
        }
        return methodCount[amount];
    }
}
