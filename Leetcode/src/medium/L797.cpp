#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
// this is acyclic graph, or you need to test for repetition
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        int n;
        n=graph.size();
        vector<vector<int>>result;
 //I will use dfs
        vector<int>depth;
        depth.push_back(0);
        dfs(0,n-1,depth,graph,result);
        return result;
    }
    void dfs(int cur,int end,vector<int>&depth,vector<vector<int>>& graph,vector<vector<int>>& result){
        // the base case;
        if(cur==end){;
            result.push_back(depth);
            return;
        }
        for (int i:graph[cur]){
               depth.push_back(i);
               dfs(i,end,depth,graph,result);
               depth.pop_back();
        }
    }
};