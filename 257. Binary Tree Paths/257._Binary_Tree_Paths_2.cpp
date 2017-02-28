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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        if (root != NULL) {
            vector<string> left = binaryTreePaths(root->left);
            vector<string> right = binaryTreePaths(root->right);
            string current = std::to_string(root->val);
            if (left.empty() && right.empty()) {
                result.push_back(current);
            } else {
                for (int i = 0; i < left.size(); i++)
                    result.push_back(current + "->" + left.at(i));
                for (int j = 0; j < right.size(); j++)
                    result.push_back(current + "->" + right.at(j));
            }
        }
        return result;
    }
};