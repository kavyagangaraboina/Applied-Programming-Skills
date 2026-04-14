class Solution {
    public boolean hasPathSum(TreeNode r, int s) {
        if (r == null) return false;
        if (r.left == null && r.right == null) return s == r.val;
        return hasPathSum(r.left, s - r.val) || hasPathSum(r.right, s - r.val);
    }
}