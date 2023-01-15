#include <bits/stdc++.h>
using namespace std;

class UnionFind
{
private:
    // rank is the addon for the priority of the union-find
    vector<int> parent;

public:
    UnionFind(int size)
    {
        parent.resize(size);
        // set parents for array to themselves
        for (int i = 0; i < size; i++)
        {
            parent[i] = i;
        }
    }
    // find and reduce the route to parent
    int find(int x)
    {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    void union_set(int x, int y)
    {
        int xset = find(x), yset = find(y);
        if (xset == yset)
        {
            return;
            parent[xset] = yset;
    }
};

class Solution {
public:
    string smallestEquivalentString(string s1, string s2, string baseStr) {
        
    }
};