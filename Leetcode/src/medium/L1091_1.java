package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L1091_1 {
     // new path to search
     private int[] Search=new int[]{0,1,1,-1,0,-1,-1,1,0};
     public int shortestPathBinaryMatrix(int[][] grid) {
         int m=grid.length,n=grid[0].length;
         if(grid[0][0]==1||grid[m-1][n-1]==1){
            return -1;
        }
         // Dijikstra record the shortest path to each point.
         int[][] dist=new int [m][n];
         for (int i=0;i<m;i++){
             Arrays.fill(dist[i],Integer.MAX_VALUE);
         }
         // use distance as criteria
         PriorityQueue<int[]>path=new PriorityQueue<>(Comparator.comparingInt(a ->a[0]));
         // distance, row, column
         path.offer(new int[]{1,0,0});
         dist[0][0]=1;
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
             // update path in 8 directions
             for(int i=0;i<8;i++){
                 // if the path is legal
                 int nr=shortest[1]+Search[i];
                 int nc=shortest[2]+Search[i+1];
                 if (nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==0){  
                     // if the path can update the shorest
                     if (dist[shortest[1]][shortest[2]]+1<dist[nr][nc]){
                         dist[nr][nc]=dist[shortest[1]][shortest[2]]+1;
                         path.offer(new int[]{dist[nr][nc],nr,nc});
                     }
                 }
             }
         }
 
         return -1;
     }   
}
