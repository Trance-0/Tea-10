package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L1519_4 {
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

                         
    // this code is iterative DFS for your better understanding
    // this DFS only update map.
    // this array is used to check repeated visits
    private boolean[] wasInSequence = new boolean[vcount];

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        vcount = n;
        label = labels;
        map = new int[n][26];
wasInSequence=new boolean[n];
        AdjacencyList rawGraph = new AdjacencyList(vcount);
        for (int[] i : edges) {
            rawGraph.add(i[0], i[1], false);
        }
        // System.out.println(trueGraph.toString());
        recursiveDFS(0,rawGraph);
        return generateMap();
    }

    private int[] generateMap() {
        int[] result=new int[vcount];
        for(int i=0;i<vcount;i++){
            result[i]=map[i][label.charAt(i) - 97];
        }
        return result;
    }

    // this method is used to update map
    private void recursiveDFS(int current, AdjacencyList graph) {
        // add your condition here
        map[current][label.charAt(current)-97]+=1;
        wasInSequence[current]=true;
        for (int i : graph.get(current)) {
            if (wasInSequence[i] == false) {
                wasInSequence[i] = true;
                recursiveDFS(i, graph);
                for(int j=0;j<26;j++){
                    map[current][j]+=map[i][j];
                }
            }
        }
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
        L1519_4 a = new L1519_4();
        int n = 7;
        // [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        String labels = "abaedcd";
        int[] result = a.countSubTrees(n, edges, labels);
        a.printArray(result);
    }
}
// sorry, this code timed out.
