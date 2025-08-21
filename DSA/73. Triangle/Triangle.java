import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                triangle.get(row).set(col, triangle.get(row).get(col) + 
                    Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        Triangle triangleSolver = new Triangle();
        
        List<List<Integer>> triangle1 = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );
        System.out.println("Minimum path sum for triangle 1: " + triangleSolver.minimumTotal(triangle1)); // Output: 11

        List<List<Integer>> triangle2 = List.of(
            List.of(-10)
        );
        System.out.println("Minimum path sum for triangle 2: " + triangleSolver.minimumTotal(triangle2)); // Output: -10

        List<List<Integer>> triangle3 = List.of(
            List.of(1),
            List.of(2, 3),
            List.of(4, 5, 6),
            List.of(7, 8, 9, 10)
        );
        System.out.println("Minimum path sum for triangle 3: " + triangleSolver.minimumTotal(triangle3)); // Output: 16
    }
}
