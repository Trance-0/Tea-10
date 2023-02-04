package contest;

import java.util.LinkedList;

public class B97_4 {
    class Solution {
        private final int[]check={0,1,1,-1,0,-1,-1,1,0};
        private final int[]flow={0,1,0};
        private boolean testPath(int m, int n,int[][]grid){
            boolean[][]isCheck=new boolean[m][n];
            LinkedList<int[]>queue=new LinkedList<int[]>();
            queue.add(new int[]{0,0});
            isCheck[0][0]=true;
            while(!queue.isEmpty()){
                int[] temp=queue.poll();
                for(int i=1;i<3;i++){
                    int x=temp[0]+flow[i-1];
                    int y=temp[1]+flow[i];
                    if(x<m&&x>=0&&y<n&&y>=0&&grid[x][y]==1&&isCheck[x][y]==false){
                        isCheck[x][y]=true;
                        queue.add(new int[]{x,y});
                        if(x==m-1&&y==n-1){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        private void erode(int[]start,int m,int n,int[][]grid,int[][]erodeMap){
            //bfs + 1 step
            LinkedList<int[]>queue=new LinkedList<int[]>();
            queue.add(start);
            erodeMap[start[0]][start[1]]=0;
            
            while(!queue.isEmpty()){
                int[] temp=queue.poll();
                for(int i=1;i<9;i++){
                    int x=temp[0]+check[i-1];
                    int y=temp[1]+check[i];
                    if(x<m&&x>=0&&y<n&&y>=0&&erodeMap[x][y]==1){
                        erodeMap[x][y]=0;
                        if(grid[x][y]==0){
                            queue.add(new int[]{x,y});
                        }
                    }
                }
            }
        }
        public boolean isPossibleToCutPath(int[][] grid) {
            // cut from up to down and cut from down to up
            int m=grid.length,n=grid[0].length;
            // if there is only one path
            if(m==1||n==1){
                if(m+n==3){
                    return false;
                }
                return true;
            }
            int[][]erodeMap=new int[m][n];
                 for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    erodeMap[i][j]=1;
                }
            }
            //erode on four edge
            if(!testPath(m, n, grid)){
                return true;
            }
            for(int i=1;i<m;i++){
                if(grid[i][0]==0){
                    erode(new int[]{i,0}, m, n, grid, erodeMap);
                }
            }
            for(int i=1;i<n;i++){
                if(grid[0][i]==0){
                    erode(new int[]{0,i}, m, n, grid, erodeMap);
                }
            }
            for(int i=0;i<n-1;i++){
                if(grid[m-1][i]==0){
                    erode(new int[]{m-1,i}, m, n, grid, erodeMap);
                }
            }
            for(int i=0;i<m-1;i++){
                if(grid[i][n-1]==0){
                    erode(new int[]{i,n-1}, m, n, grid, erodeMap);
                }
            }
            return !testPath(m,n,erodeMap);
        }
    }
        // public static void main(String[] args) {
        //     B97_4 a=new B97_4();
        //     int[][]grid={{1,0,0,1},
        //                 {1,0,1,1},
        //                 {1,1,1,1},
        //                 {1,1,1,1}};
        //     System.out.println(a.isPossibleToCutPath(grid));
        // }
}
