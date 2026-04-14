import java.util.Queue;
import java.util.LinkedList;

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        // Remove old requests
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
