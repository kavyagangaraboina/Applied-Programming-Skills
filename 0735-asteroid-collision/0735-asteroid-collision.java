import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> s = new Stack<>();
        for (int x : a) {
            while (!s.isEmpty() && x < 0 && s.peek() > 0) {
                if (s.peek() < -x) s.pop();
                else if (s.peek() == -x) { s.pop(); x = 0; }
                else { x = 0; break; }
            }
            if (x != 0) s.push(x);
        }
        int[] r = new int[s.size()];
        for (int i = r.length - 1; i >= 0; i--) r[i] = s.pop();
        return r;
    }
}