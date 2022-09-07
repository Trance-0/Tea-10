package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L939_1 {
    // learning how to use set to solve problem
    public int minAreaRect(int[][] points) {
        // ask Hashmap for exsistence of points.
        Map<Integer, Set<Integer>> magicalConch = new HashMap<Integer, Set<Integer>>();
        for (int[] i : points) {
            if (!magicalConch.containsKey(i[0])) {
                magicalConch.put(i[0], new HashSet<>());
            }
            magicalConch.get(i[0]).add(i[1]);
        }
        int minArea = Integer.MAX_VALUE;
        // check two points to see if they can create a rectangle
        for (int i[] : points) {
            for (int j[] : points) {
                // if the two points overlaped
                if (i[0] == j[0] || i[1] == j[1]) {
                    continue;
                }
                // if the two points can create rectangle
                if (magicalConch.get(i[0]).contains(j[1]) && magicalConch.get(j[0]).contains(i[1])) {
                    minArea = Math.min(Math.abs(i[0] - j[0]) * Math.abs(i[1] - j[1]), minArea);
                }
            }
        }

        // This section can also be written as return minArea == Integer.MAX_VALUE ? 0 :
        // minArea;
        if (minArea == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minArea;
        }
    }
}
