import java.util.*;

class Solution {
    public int[] finalPrices(int[] p) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < p.length; i++) {
            while (!s.isEmpty() && p[s.peek()] >= p[i])
                p[s.pop()] -= p[i];
            s.push(i);
        }
        return p;
    }
}