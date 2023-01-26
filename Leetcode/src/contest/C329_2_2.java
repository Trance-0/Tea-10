package contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C329_2_2 {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m=score.length,n=score[0].length;
        int[][]result=new int[m][n];
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o2[k]-o1[k];
            }
            
        });
        for(int i=0;i<m;i++){
            pq.add(score[i]);
        }
        for(int i=0;i<m;i++){
            result[i]=pq.poll();
        }
        return result;
    }
}
