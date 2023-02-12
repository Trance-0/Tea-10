package contest;

import java.util.Collections;
import java.util.PriorityQueue;

public class C331_1 {
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer>queue = new PriorityQueue<>(Collections.reverseOrder());
            for(int i:gifts){
                queue.add(i);
            }
            long result=0;
            for(int i=0;i<k;i++){
                int temp=queue.poll();
                queue.add((int)Math.sqrt(temp));
            }
            for(int i:queue){
                result+=i;
            }
            return result;
        }
    }
}
