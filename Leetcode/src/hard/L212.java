package hard;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class L212 {
    class Node {
        private char value;
        private Node parNode;
        private Node[] childs = new Node[26];
        private boolean isEnd;
        public Node(Node p,char input,boolean stop) {
            parNode=p;
            value = input;
            isEnd=stop;
        }
    }

    private int m = 0, n = 0;
    private final int[] displacement = { 0, 1, 0, -1 };
    private final char end = '#';

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        Set<String> result = new HashSet<String>();
        // build prefix tree
        Node prefixTree = new Node(null,' ',false);
        for (String i : words) {
            Node currNode = prefixTree;
            char[] fragments = i.toCharArray();
            for (int j=0;j<i.length();j++) {
                if (currNode.childs[fragments[j] - 97] == null) {
                    currNode.childs[fragments[j] - 97] = new Node(currNode,fragments[j],false);
                }
                currNode = currNode.childs[fragments[j] - 97];
            }
            currNode.isEnd = true;
        }
        // for each unit in board, DFS it to test if is in
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                DFS(result, board, prefixTree.childs[board[i][j]-97], i, j);
            }
        }
        ArrayList<String> finalResult = new ArrayList<String>();
        for (String i : result) {
            finalResult.add(i);

        }
        return finalResult;
    }

    private void DFS(Set<String> result, char[][] board, Node cur, int startx, int starty) {
        // legitimate check
        if(cur==null){
            return;
        }
        // base case
        if (cur.isEnd) {
            result.add(reverseTracing(cur));
        } 
        char removedChar = board[startx][starty];
        // else, continue searching
        board[startx][starty] = end;
        for (int i = 0; i < 4; i++) {
            int ni = startx+ displacement[i], nj = starty + displacement[(i + 1) % 4];
            // if the new pos is legal and not visited
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] != '#'
                    && cur.childs[board[ni][nj] - 97] != null) {
                DFS(result, board, cur.childs[board[ni][nj] - 97], ni, nj);
            }
        }
        board[startx][starty] = removedChar;
    }

    private String reverseTracing(Node start) {
        StringBuilder sb = new StringBuilder();
        while (start.value!=' ') {
            sb.append(start.value);
            start=start.parNode;
        }
        return sb.reverse().toString();
    }
}