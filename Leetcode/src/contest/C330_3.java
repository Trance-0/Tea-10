package contest;

import java.util.ArrayList;
import java.util.LinkedList;

public class C330_3 {
    private void constructBags(int idx, int n,int k,LinkedList<int[]>distr,long[]localPrice,int[]weights,long[]result){
        // invalid
        if(k>distr.size()-idx){
            return;
        }
        // valid
        if(distr.size()==k){
            result[0]=Math.max(result[0], localPrice[0]);
            result[1]=Math.min(result[1], localPrice[1]);
        }
        for(int i=idx;i<n-distr.size();i++){
            int[]temp=new int[2];
            temp[0]=weights[idx];
            temp[1]=weights[i];
            localPrice[0]=Math.max(temp[0]+temp[1], localPrice[0]);
            localPrice[1]=Math.min(temp[0]+temp[1], localPrice[1]);
            distr.add(temp);
            constructBags(i+1, n, k, distr,localPrice, weights, result);
            distr.remove(temp);
        }
    }
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        if(n==k){
            return 0;
        }
        long[]localResult=new long[2];
        long[]result={0,Long.MAX_VALUE};
        LinkedList<int[]>distr=new LinkedList<int[]>();
        constructBags(0, n, k,distr,localResult,weights, result);
        return result[0]-result[1];
    }
}
