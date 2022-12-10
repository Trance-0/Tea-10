package medium;

import java.util.LinkedList;
import java.util.Queue;

public class L1926 {
    // classic BFS
    private final int[] search = { 0, 1, 0, -1, 0 };

    public int nearestExit(char[][] maze, int[] entrance) {
        int depth = 0;
        Queue<int[]> points = new LinkedList<int[]>();
        points.add(entrance);
        maze[entrance[0]][entrance[1]] = 35;
        // empty is 46 '.', filled is 43 '+'
        boolean reached = false;
        while (!points.isEmpty()) {
            for (int i = points.size(); i > 0; i--) {
                // poll points
                int[] temp = points.poll();
                for (int j = 0; j < 4; j++) {
                    // legitimate test
                    if (temp[0] + search[j] < maze.length
                            && temp[0] + search[j] >= 0
                            && temp[1] + search[j + 1] < maze[0].length
                            && temp[1] + search[j + 1] >= 0) {
                        // if points next to is not visited, add to points and mark.
                        if (maze[temp[0] + search[j]][temp[1] + search[j + 1]] == 46) {
                            // test if search is on boarder
                            if (temp[0] + search[j] == maze.length - 1
                                    || temp[0] + search[j] == 0
                                    || temp[1] + search[j + 1] == maze[0].length - 1
                                    || temp[1] + search[j + 1] == 0) {
                                reached=true;
                                break;
                            }
                            maze[temp[0] + search[j]][temp[1] + search[j + 1]] = 35;
                            int[] newPos = { temp[0] + search[j], temp[1] + search[j + 1] };
                            points.add(newPos);
                        }
                    }
                }
            }
            depth++;
            if (reached) {
                break;
            }
        }
        return reached ? depth:-1;
    }
}
