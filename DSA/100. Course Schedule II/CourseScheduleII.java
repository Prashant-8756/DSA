import java.util.*;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (index == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }

    // Test cases
    public static void main(String[] args) {
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println("Test case 1 output: " + Arrays.toString(findOrder(numCourses1, prerequisites1)));
        // Expected output: [0,1,2,3] or [0,2,1,3]

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1,0},{0,1}};
        System.out.println("Test case 2 output: " + Arrays.toString(findOrder(numCourses2, prerequisites2)));
        // Expected output: []

        int numCourses3 = 3;
        int[][] prerequisites3 = {};
        System.out.println("Test case 3 output: " + Arrays.toString(findOrder(numCourses3, prerequisites3)));
        // Expected output: [0,1,2] or any permutation

        int numCourses4 = 1;
        int[][] prerequisites4 = {};
        System.out.println("Test case 4 output: " + Arrays.toString(findOrder(numCourses4, prerequisites4)));
        // Expected output: [0]
    }
}
