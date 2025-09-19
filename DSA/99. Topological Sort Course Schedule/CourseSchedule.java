import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int dest = prereq[0];
            int src = prereq[1];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visitedCourses = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            visitedCourses++;

            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return visitedCourses == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Test case 1: " + cs.canFinish(numCourses1, prerequisites1)); // true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Test case 2: " + cs.canFinish(numCourses2, prerequisites2)); // false

        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Test case 3: " + cs.canFinish(numCourses3, prerequisites3)); // true

        int numCourses4 = 4;
        int[][] prerequisites4 = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
        System.out.println("Test case 4: " + cs.canFinish(numCourses4, prerequisites4)); // false
    }
}
