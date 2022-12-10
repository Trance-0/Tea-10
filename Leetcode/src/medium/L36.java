package medium;

public class L36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[] checker=new boolean[9];
        // horizontal scan
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!=46){
                    if(checker[board[i][j]-49]){
                        return false;
                    }else{
                        checker[board[i][j]-49]=true;
                    }
                }
            }
            checker=new boolean[9];
        }
        // vertical scan
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]!=46){
                    if(checker[board[j][i]-49]){
                        return false;
                    }else{
                        checker[board[j][i]-49]=true;
                    }
                }
            }
            checker=new boolean[9];
        }
        // cell scan, a little bit complicated.
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i/3*3+j/3][i%3*3+j%3]!=46){
                    if(checker[board[i/3*3+j/3][i%3*3+j%3]-49]){
                        return false;
                    }else{
                        checker[board[i/3*3+j/3][i%3*3+j%3]-49]=true;
                    }
                }
            }
            checker=new boolean[9];
        }
        return true;
    }
}
