import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int end = prerequisite[0];
            int start = prerequisite[1];
            graph.get(start).add(end);
            indegree[end]++;
        }

        int[] order = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer start = queue.poll();
            order[count++] = start;
            for (Integer end : graph.get(start)) {
                indegree[end]--;
                if (indegree[end] == 0) {
                    queue.offer(end);
                }
            }
        }
        if (count == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }
}
