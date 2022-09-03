package medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.tools.SimpleJavaFileObject;

public class L1631_1 {
    // new path to search
    private int[] Search=new int[]{0,1,0,-1,0};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        // Dijikstra record the shortest path to each point.
        int[][] dist=new int [m][n];
        for (int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        // use distance as criteria
        PriorityQueue<int[]>path=new PriorityQueue<>(Comparator.comparingInt(a ->a[0]));
        // distance, row, column
        path.offer(new int[]{0,0,0});
        dist[0][0]=0;

        // start searching
        while (!path.isEmpty()){
            int[] shortest=path.poll();
            if(shortest[0]>dist[shortest[1]][shortest[2]]){
                // if the path cannot update the shortest distance 
                continue;
            }
            if(shortest[1]==m-1&&shortest[2]==n-1){
                // if reached the end
                return shortest[0];
            }
            // update path in 4 directions
            for(int i=0;i<4;i++){
                // if the path is legal
                if (shortest[1]+Search[i]>=0&&shortest[1]+Search[i]<m&&shortest[2]+Search[i+1]>=0&&shortest[2]+Search[i+1]<n){  
                    // if the path can update the shorest
                    int newDis= Math.max(shortest[0],Math.abs(heights[shortest[1]+Search[i]][shortest[2]+Search[i+1]]-heights[shortest[1]][shortest[2]]));
                    if (newDis<dist[shortest[1]+Search[i]][shortest[2]+Search[i+1]]){
                        dist[shortest[1]+Search[i]][shortest[2]+Search[i+1]]=newDis;
                        path.offer(new int[]{newDis,shortest[1]+Search[i],shortest[2]+Search[i+1]});
                    }
                }
            }
        }

        return 0;
    }   
}
