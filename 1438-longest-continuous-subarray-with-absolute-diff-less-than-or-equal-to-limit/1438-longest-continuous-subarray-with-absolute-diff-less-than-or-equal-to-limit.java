import java.util.*;

class Solution {
    public int longestSubarray(int[] a, int limit) {
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        int l = 0, res = 0;
        for (int r = 0; r < a.length; r++) {
            while (!max.isEmpty() && a[r] > max.peekLast()) max.pollLast();
            while (!min.isEmpty() && a[r] < min.peekLast()) min.pollLast();
            max.add(a[r]);
            min.add(a[r]);
            while (max.peek() - min.peek() > limit) {
                if (max.peek() == a[l]) max.poll();
                if (min.peek() == a[l]) min.poll();
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}