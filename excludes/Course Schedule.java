package excludes;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            if (!graph.containsKey(pre[1])) {
                graph.put(pre[1], new HashSet<Integer>());
            }
            graph.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                Set<Integer> adjecent = graph.getOrDefault(cur, new HashSet<>());
                for (int num : adjecent) {
                    indegree[num]--;
                    if (indegree[num] == 0) {
                        queue.offer(num);
                    }
                }

            }
        }

        for (int d : indegree) {
            if (d != 0) {
                return false;
            }
        }

        return true;        
    }
}