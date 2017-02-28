/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void binaryTreePaths(vector<string>& result, TreeNode* root, string str) {
        if (!root->left && !root->right)
            result.push_back(str);
        if (root->left)
            binaryTreePaths(result, root->left, str + "->" + to_string(root->left->val));
        if (root->right)
            binaryTreePaths(result, root->right, str + "->" + to_string(root->right->val));
    }
    
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        if (root)
            binaryTreePaths(result, root, to_string(root->val));
        return result;
    }
};