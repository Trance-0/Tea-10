package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L1519_3 {
    // goal to find number of subnode with same tag.
    // method: **dfs** for each, and record node count with return to parent nodes.
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

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (LinkedList<Integer> i : adjacentPoints) {
                sb.append("[");
                for (int j : i) {
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
    private AdjacencyList graph;
    private int[][] map; // you will only have 26 letter, if the color is more than 26, you may need to
                         // count color count.

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        vcount = n;
        label = labels;
        map = new int[n][26];
        AdjacencyList rawGraph = new AdjacencyList(vcount);
        for (int[] i : edges) {
            rawGraph.add(i[0], i[1], false);
        }
        // System.out.println(trueGraph.toString());
        return iterativeDFS(vcount, rawGraph);
    }

    // this code is iterative DFS for your better understanding
    // this DFS only update map.
    private int[] iterativeDFS(int vcount, AdjacencyList graph) {

        // this queue is used to record search path
        LinkedList<Integer> sequence = new LinkedList<Integer>();
        // this array is used to check repeated visits
        boolean[] wasInSequence = new boolean[vcount];
        // search start with i
        sequence.push(0);
        wasInSequence[0] = true;
        while (sequence.isEmpty() == false) {
            // peek first, or you will only iterate the node once.
            int currentSearch = sequence.peek();
            boolean isCurrentSearchingEmpty = true;
            for (int k : graph.get(currentSearch)) {
                // to get next search
                if (wasInSequence[k] == false) {
                    isCurrentSearchingEmpty = false;
                    sequence.push(k);
                    wasInSequence[k] = true;
                    break;
                }
            }
            // when searching reached end of tree.
            if (isCurrentSearchingEmpty == true) {
                // in this line, 97 is the 'a' in ascii code, idx is the index of color of
                // currentSearch.
                int idx = label.charAt(currentSearch) - 97;
                updateIdxInParent(sequence, idx);
                sequence.pop();
            }
        }
        // count search for each.
        int[] searchCount = new int[vcount];
        for (int i = 0; i < vcount; i++) {
            searchCount[i] = map[i][label.charAt(i) - 97];
        }
        return searchCount;
    }

    // update map by idx
    private void updateIdxInParent(LinkedList<Integer> sequence, int idx) {
        for (int parent : sequence) {
            map[parent][idx] += 1;
        }
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

    private void printArray(int[] arr) {
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
        L1519_3 a = new L1519_3();
        int n = 7;
        // [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        String labels = "abaedcd";
        int[] result = a.countSubTrees(n, edges, labels);
        a.printArray(result);
    }
}
// sorry, this code timed out.
