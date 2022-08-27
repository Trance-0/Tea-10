package medium;

import java.util.ArrayList;
import java.util.List;

public class L77_1 {
    // lets do something easy
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result=new ArrayList<List<Integer>>();
           merge(result,new ArrayList<>(),1,n,k);
            return result;
        }
        private void merge(List<List<Integer>>result,List<Integer>to_merge, int start, int n, int k){
            if(k==0) {
                result.add(new ArrayList<Integer>(to_merge));
                return;
            }
            for(int i=start;i<=n;i++) {
                // [1],[2],[3]
                to_merge.add(i);
                // [1,2],[1,3],[1,4]
                merge(result, to_merge, i+1, n, k-1);
                to_merge.remove(to_merge.size()-1);
            }
        }
}
