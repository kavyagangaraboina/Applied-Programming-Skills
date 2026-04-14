class MyCircularQueue {
    int[] q;
    int f = 0, r = -1, s = 0, cap;

    public MyCircularQueue(int k) {
        cap = k;
        q = new int[k];
    }

    public boolean enQueue(int v) {
        if (isFull()) return false;
        r = (r + 1) % cap;
        q[r] = v;
        s++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        f = (f + 1) % cap;
        s--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[f];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[r];
    }

    public boolean isEmpty() {
        return s == 0;
    }

    public boolean isFull() {
        return s == cap;
    }
}