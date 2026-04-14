import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] a, int[] b) {
        Map<Integer,Integer> m = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int x : b) {
            while (!s.isEmpty() && s.peek() < x)
                m.put(s.pop(), x);
            s.push(x);
        }
        while (!s.isEmpty()) m.put(s.pop(), -1);
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) r[i] = m.get(a[i]);
        return r;
    }
}