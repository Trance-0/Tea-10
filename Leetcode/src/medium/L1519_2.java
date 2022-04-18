package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L1519_2 {
    // goal to find number of subnode with same tag.
    // method 1: **bfs** for each
    // okey, this is the official answer, I thought there might be a better one.

    // Holy shit, this is a shity directed graph with 0 as root, damn it.

    // to store the map, review forward stars.

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
            if (isDirected == false) {
                adjacentPoints[end].add(start);
            }
        }

        public LinkedList<Integer> get(int start) {
            return adjacentPoints[start];
        }
        public String toString(){
            StringBuilder sb=new StringBuilder();
            sb.append("{");
            for(LinkedList<Integer> i:adjacentPoints){
                sb.append("[");
                for(int j:i){
                    sb.append(j);
                    sb.append(" ");
                }
                sb.append("]");
                sb.append("\n");
            }
            sb.append("}");
            return sb.toString();
        }
    }


    private int vcount;
    private String label;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        vcount = n;
        label = labels;
        AdjacencyList rawGraph = new AdjacencyList(vcount);
        for (int[] i : edges) {
            rawGraph.add(i[0], i[1], false);
        }
        //System.out.println(rawGraph.toString());
        AdjacencyList trueGraph = iterativeBFS(vcount, rawGraph);
        //System.out.println(trueGraph.toString());
        return iterativeDFS(vcount, trueGraph);
    }

    // A review for BFS and DFS
    // BFS use queue to store past value
    // DFS use stack to store past value

    // this code is iterative BFS for your better understanding
    private AdjacencyList iterativeBFS(int vcount, AdjacencyList graph) {
        AdjacencyList searchCount = new AdjacencyList(vcount);
        // this queue is used to record points to iterate
        Queue<Integer> sequence = new LinkedList<Integer>();
        // this array is used to check repeated visits
        boolean[] wasInSequence = new boolean[vcount];
        // search start with 0 construct a new graph begin with 0
        sequence.add(0);
        wasInSequence[0] = true;
        while (sequence.isEmpty() == false) {
            int currentSearch = sequence.poll();
            // add your condition to check k here
            for (int k : graph.get(currentSearch)) {
                // to get further search
                if (wasInSequence[k] == false) {
                    sequence.add(k);
                    searchCount.add(currentSearch, k, true);
                    wasInSequence[k] = true;
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
            // to debug
            //LinkedList<Integer> sequence = new LinkedList<Integer>();
            Stack<Integer> sequence = new Stack<Integer>();
            // this array is used to check repeated visits
            boolean[] wasInSequence = new boolean[vcount];
            // search start with i
            // add self value;
            searchCount[i]=1;
            sequence.push(i);
            wasInSequence[i] = true;
            while (sequence.isEmpty() == false) {
                int currentSearch = sequence.peek();
                boolean isCurrentSearchingEmpty=true;
                for (int k : graph.get(currentSearch)) {
                    //System.out.println(String.format("Searching on %s, current checking %s ", currentSearch,k));
                    // to get next search
                    if (wasInSequence[k] == false) {
                        //System.out.println(String.format("Find!"));
                        sequence.push(k);
                        // add your condition to check k here, do not move this shit to the prior loop because you will check it multiple time.
                if (label.charAt(k) == label.charAt(i)) {
                    searchCount[i] += 1;
                }
                        isCurrentSearchingEmpty=false;
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
        // add your condition here
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

    private void printArray(LinkedList<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : arr) {
            sb.append(i);
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }
    private void printArray( int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : arr) {
            sb.append(i);
            sb.append(",");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    // test
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L1519_2 a = new L1519_2();
        int n = 7;
        //[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 } , { 1, 5 } , { 2, 3 } , { 2, 6 } };
        String labels ="abaedcd";
        int[] result = a.countSubTrees(n, edges, labels);
        a.printArray(result);
    }
}
// sorry, this code timed out.
