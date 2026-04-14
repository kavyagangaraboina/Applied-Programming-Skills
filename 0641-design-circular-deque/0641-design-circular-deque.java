import java.util.*;

class MyCircularDeque {
    int[] d;
    int f = 0, r = 0, size = 0, k;

    public MyCircularDeque(int k) {
        this.k = k;
        d = new int[k];
    }

    public boolean insertFront(int v) {
        if (isFull()) return false;
        f = (f - 1 + k) % k;
        d[f] = v;
        size++;
        return true;
    }

    public boolean insertLast(int v) {
        if (isFull()) return false;
        d[r] = v;
        r = (r + 1) % k;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        f = (f + 1) % k;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        r = (r - 1 + k) % k;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : d[f];
    }

    public int getRear() {
        return isEmpty() ? -1 : d[(r - 1 + k) % k];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}