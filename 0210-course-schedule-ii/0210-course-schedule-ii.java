import java.util.*;

class Solution {

    public int[] findOrder(int numCourses,
                           int[][] prerequisites) {

        List<Integer>[] graph =
            new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {

            graph[pre[1]].add(pre[0]);

            indegree[pre[0]]++;
        }

        Queue<Integer> queue =
            new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];

        int index = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            result[index++] = current;

            for (int next : graph[current]) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (index == numCourses) {
            return result;
        }

        return new int[0];
    }
}