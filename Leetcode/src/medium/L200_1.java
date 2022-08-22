package medium;

public class L200_1 {
        // union set, classic
    /* full version of disjoint set */
   
    public int numIslands(char[][] grid) {
        int result=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                   DFSMarking(grid, i,j);
                   result++;
                }
            }
        }
        return result;
    }
    private void DFSMarking(char[][] grid, int i,int j){
        if(i>=0&&j>=0&&i<grid.length&&j<grid[0].length&&grid[i][j]=='1'){
        grid[i][j]='0';
        DFSMarking(grid,i+1,j);
        DFSMarking(grid,i-1,j);
        DFSMarking(grid,i,j+1);
        DFSMarking(grid,i,j-1);
        }
    }
}
