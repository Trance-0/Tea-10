<<<<<<< Updated upstream
#include <bits/stdc++.h>;
=======
#include <bits/stdc++.h>
>>>>>>> Stashed changes
using namespace std;
class Solution {
public:
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
<<<<<<< Updated upstream
        int n = 0;
        n = graph.size();
        vector<vector<int>> result;
        // I will use dfs
        vector<int> depth;
        vector<bool> arr;
        for (int i = 0; i < n; i++) {
            arr.push_back(false);
        }
        arr[0] = true;
        depth.push_back(0);
        dfs(n - 1, arr, depth, graph, result);
        return result;
=======
        int n=0;
        n=graph.size();
        vector<vector<int>>result;
 //I will use dfs
        vector<int>depth;
        vector<bool>arr(n);
        for(int i=0;i<n;i++){
arr[n]=false;
        }
        arr[0]=true;
        depth.push_back(0);
        dfs(n-1,arr,depth,graph,result);
        return result;
    }
    void dfs(int end,vector<bool>& hist,vector<int>&depth,vector<vector<int>>& graph,vector<vector<int>>result){
        // the base case;
        if(depth.back()==end){;
            result.push_back(depth);
            return;
        }
        for (int i:graph[depth.back()]){
            if(!hist[i]){
               hist[i]=true;
               depth.push_back(i);
               dfs(end,hist,depth,graph,result);
               depth.pop_back();
                hist[i]=false;
            }
        }
>>>>>>> Stashed changes
    }
    void dfs(int end, vector<bool>& hist, vector<int>& depth,
        vector<vector<int>>& graph, vector<vector<int>> result) {
        // the base case;
        if (depth.back() == end) {
            ;
            result.push_back(depth);
            return;
        }
        for (int i : graph[depth.back()]) {
            if (!hist[i]) {
                hist[i] = true;
                depth.push_back(i);
                dfs(end, hist, depth, graph, result);
                depth.pop_back();
                hist[i] = false;
            }
        }
    }
};
int main() {
    Solution a;
    vector<vector<int>> graph;
    std::cout << allPathsSourceTarget(graph);
}
