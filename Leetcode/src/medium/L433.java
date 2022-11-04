package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class L433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // use BFS to find the shortest path
        // queue to store the path
        Queue<String> searchSequence = new LinkedList<String>();
        // check if visited before
        Set<String> visited = new HashSet<String>();
        // Hash set for bank
        Set<String> range = new HashSet<String>(Arrays.asList(bank));
        // store the depth of searching
        int depth = 0;
        // store mutation possibilities
        char[] mutation = { 'A', 'T', 'C', 'G' };
        searchSequence.add(startGene);
        visited.add(startGene);
        while (searchSequence.size() > 0) {
            // seach for each depth
            for (int k = searchSequence.size()-1;k>=0; k--) {
                String cur = searchSequence.poll();
                if (cur.compareTo(endGene) == 0) {
                    return depth;
                }
                char[] temp = cur.toCharArray();
                // make modification
                for (int i = 0; i < 8; i++) {
                    for (char j : mutation) {
                        temp[i] = j;
                        // if the new path is not visited before
                        if (range.contains(String.valueOf(temp)) && !visited.contains(String.valueOf(temp))) {
                            searchSequence.add(String.valueOf(temp));
                            visited.add(String.valueOf(temp));
                        } 
                    }
                     // change the temp back
                        temp = cur.toCharArray();
                }
            }
            depth += 1;
        }
        return -1;
        // return -1 for no path found.
    }
}
