import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode r) {
        List<Integer> l = new ArrayList<>();
        dfs(r, 0, l);
        return l;
    }

    void dfs(TreeNode n, int d, List<Integer> l) {
        if (n == null) return;
        if (d == l.size()) l.add(n.val);
        dfs(n.right, d + 1, l);
        dfs(n.left, d + 1, l);
    }
}