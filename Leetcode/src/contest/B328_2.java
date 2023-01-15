package contest;

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][]dif=new int[n+1][n+1];
        for(int[] i :queries){
            //get query
            for(int j=i[0];j<i[2]+1;j++){
                dif[j][i[1]]++;
                dif[j][i[3]+1]--;
            }
        }
        int[][]result=new int[n][n];
        for(int i=0;i<n;i++){
            int save=0;
            for(int j=0;j<n;j++){
                save+=dif[i][j];
                result[i][j]=save;
            }
        }
        return result;
    }
}