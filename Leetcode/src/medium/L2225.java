package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class L2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        // winner set
        Set<Integer> winAll=new HashSet<Integer>();
        // loser set
        Set<Integer> loseOne=new HashSet<Integer>();
        Set<Integer> loseMore=new HashSet<Integer>();
        for (int[] i:matches){
            // i[0], winner operations
            // if the player never lose
            if(!loseMore.contains(i[0])&&!loseOne.contains(i[0])){
                winAll.add(i[0]);
            }
            // i[1], loser operations
            // if loser is in winAll.
            if (winAll.contains(i[1])){
                winAll.remove(i[1]);
            }
            // if loser lose once
            if(!loseMore.contains(i[1])){
                if(!loseOne.contains(i[1])){
                loseOne.add(i[1]);
                // if loser lose more
                }else{
                    loseOne.remove(i[1]);
                    loseMore.add(i[1]);
                }
            }
        }
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<>(winAll));
        result.add(new ArrayList<>(loseOne));
        result.get(0).sort(null);
        result.get(1).sort(null);
        return result;
    }
}
