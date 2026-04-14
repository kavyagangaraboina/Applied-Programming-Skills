import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length, r[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && t[i] > t[s.peek()]) {
                int j = s.pop();
                r[j] = i - j;
            }
            s.push(i);
        }
        return r;
    }
}