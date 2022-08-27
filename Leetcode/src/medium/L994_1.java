package medium;

public class L994_1 {
    // very simmilar to the island one L200_1
    private final static int[][]SEARCH={{0,1},{0,-1},{1,0},{-1,0}};
    private int[][]rottenMap;
   public int orangesRotting(int[][] grid) {
        rottenMap=new int[grid.length][grid[0].length];
        // rotten time map for each grid
        for(int i=0;i<rottenMap.length;i++){
for(int j=0;j<rottenMap[0].length;j++){
    rottenMap[i][j]=100;
}
        }
        // update rotten time
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                   rotten(grid, i, j, 0);
                }
            }
        }
        int rottenTime=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1&&rottenTime<rottenMap[i][j]){
                    rottenTime=rottenMap[i][j];
                }
            }
        }
        if(rottenTime==100){
return -1;
        }
        return rottenTime;
    }
    //update for each rotten orange
    private void rotten(int[][] grid, int i,int j,int step){
        rottenMap[i][j]=step;
        for(int[] offset:SEARCH){
            // if the next step is in reach and not rotten and 
            if(i+offset[0]>=0&&j+offset[1]>=0&&i+offset[0]<grid.length&&j+offset[1]<grid[0].length&&grid[i+offset[0]][j+offset[1]]==1&&rottenMap[i+offset[0]][j+offset[1]]>step+1){
                rotten(grid,i+offset[0],j+offset[1],step+1);
            }
        }
    }
}
