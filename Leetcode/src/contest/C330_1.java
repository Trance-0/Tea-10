package contest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int distinctIntegers(int n) {
        HashSet<Integer>board=new HashSet<Integer>();
        Queue<Integer>newElement=new LinkedList<>();
        board.add(n);
        for(int i=1;i<n;i++){
            for(int j:board){
                for(int k=1;k<n;k++){
                    if(j%k==1){
                        if(board.contains(k)){
                            continue;
                        }
                        newElement.add(k);
                        break;
                    }
                }
            }
            while(!newElement.isEmpty()){
                board.add(newElement.poll());
            }
        }
        return board.size();
    }
}