import java.util.*;

class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> m = new Stack<>();

    public void push(int x) {
        s.push(x);
        if (m.isEmpty() || x <= m.peek()) m.push(x);
    }

    public void pop() {
        if (s.pop().equals(m.peek())) m.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return m.peek();
    }
}