import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode r) {
        List<String> res = new ArrayList<>();
        dfs(r, "", res);
        return res;
    }

    void dfs(TreeNode n, String s, List<String> res) {
        if (n == null) return;
        s += n.val;
        if (n.left == null && n.right == null)
            res.add(s);
        else {
            s += "->";
            dfs(n.left, s, res);
            dfs(n.right, s, res);
        }
    }
}