import java.util.*;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图
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

        // 拓扑排序
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer start = queue.poll();
            count++;
            List<Integer> ends = graph.get(start);
            for (Integer end : ends) {
                indegree[end]--;
                if (indegree[end] == 0) {
                    queue.offer(end);
                }
            }
        }
        return count == numCourses;
    }
}
