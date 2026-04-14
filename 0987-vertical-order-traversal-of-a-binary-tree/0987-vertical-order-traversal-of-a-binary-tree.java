import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode r) {
        List<int[]> l = new ArrayList<>();
        dfs(r, 0, 0, l);
        Collections.sort(l, (a,b) -> 
            a[0]==b[0] ? (a[1]==b[1] ? a[2]-b[2] : a[1]-b[1]) : a[0]-b[0]);
        List<List<Integer>> res = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        for (int[] x : l) {
            if (x[0] != prev) {
                res.add(new ArrayList<>());
                prev = x[0];
            }
            res.get(res.size()-1).add(x[2]);
        }
        return res;
    }

    void dfs(TreeNode n, int c, int r, List<int[]> l) {
        if (n == null) return;
        l.add(new int[]{c, r, n.val});
        dfs(n.left, c-1, r+1, l);
        dfs(n.right, c+1, r+1, l);
    }
}