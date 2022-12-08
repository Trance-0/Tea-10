#include <bits/stdc++.h>

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Solution
{
public:
    bool leafSimilar(TreeNode *root1, TreeNode *root2)
    {
        stack<TreeNode*> historNode;
        while (root1->left!=nullptr){
            root1=root1->left;
        }
        while (root2->left!=nullptr){
            root2=root2->left;
        }
    }
    TreeNode* sucessor(TreeNode *sample){
        while 
    }
};