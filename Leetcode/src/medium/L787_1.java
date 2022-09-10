package medium;

import java.util.Arrays;

public class L787_1 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Bellman Ford actually.
        int[] lowestPrice=new int[n];
        for(int i=0;i<n;i++){
            lowestPrice[i]=Integer.MAX_VALUE;
        }
        lowestPrice[src]=0;
        //update lowest price
        for(int step=0;step<=k;step++){
            // find new path from checked point to unchecked point
            // remember to keep a copy for stack
           int[] temp=Arrays.copyOf(lowestPrice, n);
            for (int[]line:flights){
                if(lowestPrice[line[0]]==Integer.MAX_VALUE)continue;
                temp[line[1]]=Math.min(lowestPrice[line[0]]+line[2],temp[line[1]]);
            }
            lowestPrice=temp;
        }
        return lowestPrice[dst]==Integer.MAX_VALUE?-1:lowestPrice[dst];
    }
    public static void main(String[] args) {
        L787_1 test=new L787_1();
        System.out.println(test.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0,3,1));
    }
}
