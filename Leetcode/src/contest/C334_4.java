package contest;

import java.util.LinkedList;
import java.util.Queue;

import javax.naming.directory.SearchResult;

public class C334_4 {
    public int minimumTime(int[][] grid) {
        // i think it is bfs

        Queue<int[]> q=new LinkedList<int[]>();
  
        int[] search={-1,0,1,0,-1};
        q.add(new int[]{0,0});
        int depth=0,layer_size=1,m=grid.length,n=grid[0].length;
        boolean reachend=false;
        while(!q.isEmpty()){
            depth++;
            layer_size=q.size();
            for(int i=0;i<layer_size;i++){
                int[]cur=q.poll();
                for(int s=0;s<4;s++){
                int nm=cur[0]+search[s],nn=cur[1]+search[s+1];
                    if(nm>=0&&nm<m&&nn<n&&nn>=0&&grid[nm][nn]>=0&&grid[nm][nn]<=depth){
                        grid[nm][nn]=-1;
                        q.add(new int[]{nm,nn});
                        if(nm==m-1&&nn==n-1){
                            reachend=true;
                            break;
                        }
                    }
                }
            }
            if(reachend){
                break;
            }
        }
        return reachend?depth+1:-1;
    }
    public static void main(String[] args) {
        C334_4 a=new C334_4();
        int[][]nums={{0,1,3,2},{5,1,2,5},{4,3,8,6}};
        a.minimumTime(nums);
    }
}
