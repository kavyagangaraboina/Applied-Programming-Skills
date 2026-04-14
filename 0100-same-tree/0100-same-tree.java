class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: both are null
        if (p == null && q == null) {
            return true;
        }

        // Case 2: one is null
        if (p == null || q == null) {
            return false;
        }

        // Case 3: check value + left + right
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) &&
                   isSameTree(p.right, q.right);
        }

        return false;
    }
}