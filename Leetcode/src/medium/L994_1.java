package medium;

public class L994_1 {
    // very simmilar to the island one L200_1
    private final static int[][]SEARCH={{0,1},{0,-1},{1,0},{-1,0}};
   public int orangesRotting(int[][] grid) {
        int minRottingTime=Integer.MAX_VALUE;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                   minRottingTime=Math.min(rotten(grid, i,j,0),minRottingTime);
                }
            }
        }
        return minRottingTime;
    }
    private int rotten(int[][] grid, int i,int j,int step){
        for(int[] offset:SEARCH){
            if(grid[i][j]==2&&i+offset[0]>=0&&j+offset[1]>=0&&i+offset[0]<grid.length&&j+offset[1]<grid[0].length&&grid[i+offset[0]][j+offset[1]]==1){
                grid[i+offset[0]][j+offset[1]]=2;
                rotten(grid,i+offset[0],j+offset[1],step+1);
            }
        }
        return step;
    }
}
