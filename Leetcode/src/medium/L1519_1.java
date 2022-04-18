package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L1519_1 {
    // goal to find number of subnode with same tag.
    // method 1: **bfs** for each
    // okey, this is the official answer, I thought there might be a better one.

    // to store the map, review forward stars.
    private class FowardStars {
        private class Edge {
            int nextHead, tail;
        }

        private Edge[] stars;
        // store last added edge head
        private int[] heads;
        private int edgeIndex;

        public FowardStars(int vcount, int ecount) {

            heads = new int[vcount];
            for (int i = 0; i < vcount; i++) {
                heads[i] = -1;
            }
            stars = new Edge[ecount];
            edgeIndex = 0;
        }

        public boolean add(int start, int end) {
            if (edgeIndex < stars.length) {
                Edge tempEdge = new Edge();
                tempEdge.nextHead = heads[start];
                tempEdge.tail = end;
                heads[start] = edgeIndex;
                stars[edgeIndex] = tempEdge;
                edgeIndex++;
                return true;
            }
            return false;
        }

        public LinkedList<int[]> get(int from) {
            LinkedList<int[]> result = new LinkedList<int[]>();
            for (int i = heads[from]; i != -1; i = stars[i].nextHead) {
                int[] temp = new int[2];
                temp[0] = from;
                temp[1] = stars[i].tail;
                result.add(temp);
            }
            return result;
        }
    }

    private class AdjacencyList {
        LinkedList<Integer>[] adjacentPoints;

        public AdjacencyList(int vcount) {
            adjacentPoints = new LinkedList[vcount];
            for (int i = 0; i < vcount; i++) {
                adjacentPoints[i] = new LinkedList<Integer>();
            }
        }

        public void add(int start, int end, boolean isDirected) {
            adjacentPoints[start].add(end);
            if (!isDirected) {
                adjacentPoints[end].add(start);
            }
        }

        public LinkedList<Integer> get(int start) {
            return adjacentPoints[start];
        }
    }

    private int vcount;
    private String label;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        vcount = n;
        label = labels;
        AdjacencyList graph = new AdjacencyList(vcount);
        for (int[] i : edges) {
            graph.add(i[0], i[1], false);
        }
        return iterativeBFS(vcount, graph);
    }

    // A review for BFS and DFS
    // BFS use queue to store past value
    // DFS use stack to store past value

    // this code is iterative BFS for your better understanding
    private int[] iterativeBFS(int vcount, AdjacencyList graph) {
        int[] searchCount = new int[vcount];
        for (int i = 0; i < vcount; i++) {
            // this queue is used to record points to iterate
            Queue<Integer> sequence = new LinkedList<Integer>();
            // this array is used to check repeated visits
            boolean[] wasInSequence = new boolean[vcount];
            // search start with i
            sequence.add(i);
            wasInSequence[i] = true;
            while (sequence.isEmpty() == false) {
                int currentSearch = sequence.poll();
                // add your condition to check k here
                if (label.charAt(currentSearch) == label.charAt(i)) {
                    searchCount[i] += 1;
                }
                for (int k : graph.get(currentSearch)) {
                    // to get further search
                    if (wasInSequence[k] == false) {
                        sequence.add(k);
                        wasInSequence[k] = true;
                    }
                }
            }
        }
        return searchCount;
    }

    // this code is iterative DFS for your better understanding
    private int[] iterativeDFS(int vcount, AdjacencyList graph) {
        int[] searchCount = new int[vcount];
        for (int i = 0; i < vcount; i++) {
            // this queue is used to record search path
            Stack<Integer> sequence = new Stack<Integer>();
            // this array is used to check repeated visits
            boolean[] wasInSequence = new boolean[vcount];
            // search start with i
            sequence.push(i);
            wasInSequence[i] = true;
            while (sequence.isEmpty() == false) {
                // peek first, or you will only iterate the node once.
                int currentSearch = sequence.peek();
                boolean isCurrentSearchingEmpty = true;
                for (int k : graph.get(currentSearch)) {
                    // to get next search
                    if (wasInSequence[k] == false) {
                        // add your condition to check k here
                        if (currentSearch > 0) {
                            searchCount[i] += 1;
                        }
                        isCurrentSearchingEmpty = false;
                        sequence.push(k);
                        wasInSequence[k] = true;
                        break;
                    }
                }
                if(isCurrentSearchingEmpty==true){
                    sequence.pop();
                }
            }
        }
        return searchCount;
    }

    // this code is recursive DFS for your better understanding (Recommended)

    // this array is used to check repeated visits
    private boolean[] wasInSequence = new boolean[vcount];

    private int recursiveDFS(int current, AdjacencyList graph) {
        int searchCount = 0;
        // add your condition here
        if (current > 0) {
            searchCount++;
        }
        for (int i : graph.get(current)) {
            if (wasInSequence[i] == false) {
                wasInSequence[i] = true;
                searchCount += recursiveDFS(i, graph);
            }
        }
        return searchCount;
    }

    // this code is recursive DFS for your better understanding (Recommended)

    // this queue is used to record points to iterate
    Queue<Integer> sequence = new LinkedList<Integer>();
    // WARNING. REMEMBER TO ADD WASINSEQUENCE BOOLEAN ARRAY BEFORE YOU USE FOLLOWING
    // METHOD.

    private int recursiveBFS(AdjacencyList graph) {
        int searchCount = 0;
        int current = sequence.poll();
        if (current > 0) {
            searchCount++;
        }
        for (int i : graph.get(current)) {
            if (wasInSequence[i] == false) {
                wasInSequence[i] = true;
                sequence.add(i);
            }
        }
        if (sequence.isEmpty() == false) {
            searchCount += recursiveBFS(graph);
        }
        return searchCount;
    }

    // test
    public static void main(String[] args) {

    }
}
