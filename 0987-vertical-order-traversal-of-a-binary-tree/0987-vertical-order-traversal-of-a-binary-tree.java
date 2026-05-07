import java.util.*;

class Solution {

    class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {

            Tuple current = queue.poll();

            map.putIfAbsent(current.col, new ArrayList<>());

            map.get(current.col).add(
                new int[]{current.row, current.node.val}
            );

            if (current.node.left != null) {
                queue.offer(
                    new Tuple(
                        current.node.left,
                        current.row + 1,
                        current.col - 1
                    )
                );
            }

            if (current.node.right != null) {
                queue.offer(
                    new Tuple(
                        current.node.right,
                        current.row + 1,
                        current.col + 1
                    )
                );
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> list : map.values()) {

            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] arr : list) {
                temp.add(arr[1]);
            }

            result.add(temp);
        }

        return result;
    }
}