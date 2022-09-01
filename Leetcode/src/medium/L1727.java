package medium;

import java.util.Arrays;

class L1727{
    public int largestSubmatrix(int[][] matrix) {
        // dynamic programming
        //row
        for (int i =1;i<matrix.length;i++){
            // col
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }
        //printArray(matrix);
        int largestSubmatrixSize=0;
        for (int[]i:matrix){
            Arrays.sort(i);
            for(int j=1;j<=i.length;j++){
                largestSubmatrixSize=Math.max(j*i[i.length-j],largestSubmatrixSize);
            }
        }
        return largestSubmatrixSize;

    }
    private void printArray(int[][]test){
        StringBuilder sb=new StringBuilder();
        for(int i =0;i<test.length;i++){
            for (int j=0;j<test[i].length;j++){
                sb.append(test[i][j]);
                sb.append("");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        L1727 a=new L1727();
        int[][] testCase={{0,0,1},{1,1,1},{1,0,1}};
        System.out.println(a.largestSubmatrix(testCase));
    }
}