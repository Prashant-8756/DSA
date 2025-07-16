import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]);
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        KClosestPoints solution = new KClosestPoints();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int K = 2;
        int[][] closestPoints = solution.kClosest(points, K);

        for (int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
