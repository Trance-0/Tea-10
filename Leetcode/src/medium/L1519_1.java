package medium;

import java.util.LinkedList;

public class L1519_1 {
    // goal to find number of subnode with same tag.
    // method 1: bfs for each
    // okey, this is the official answer, I thought there might be a better one.

    // to store the map, review forward stars.
    private class FowardStars{
        private class Edge{
            int nextHead, tail;
        }
        private Edge[] stars;
        // store last added edge head
        private int[] heads;
        private int edgeIndex;
        public FowardStars (int vcount, int ecount){
            
            heads=new int[vcount];
            for (int i = 0; i < vcount; i++) {
                heads[i] = -1;
            }
            stars=new Edge[ecount];
            edgeIndex=0;
        }
        public boolean add(int start, int end){
            if (edgeIndex<stars.length){
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

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] childCount=new int[n];
        FowardStars fs=new FowardStars(n, edges.length);
        for (int[] i:edges){
            fs.add(i[0], i[1]);
        }
        for (int i =0;i<n;i++){
            childCount[i]=BFSSimNode(i,fs,labels,labels.charAt(i));
        }
        return childCount;
    }
    private int BFSSimNode(int currentNode,FowardStars fs, String lables, char targetLabel){
        int simNode=0;
        if(targetLabel==lables.charAt(currentNode)){
            simNode+=1;
        }
        // literate through the edge begin with current node
        for (int i = fs.heads[currentNode]; i != -1; i = fs.stars[i].nextHead) {
            simNode+=BFSSimNode(fs.stars[i].tail, fs, lables, targetLabel);
        }
        return simNode;
    }

    // test 
    public static void main(String[] args) {
        
    }
}
