import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;  
            }

            Queue<Pair> queue = new LinkedList<>();  
            queue.offer(new Pair(root, 1));

            while (!queue.isEmpty()) {
                Pair current = queue.poll();  
                TreeNode node = current.node;
                int depth = current.depth;

                
                if (node.left == null && node.right == null) {
                    return depth;
                }

                
                if (node.left != null) {
                    queue.offer(new Pair(node.left, depth + 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, depth + 1));
                }
            }

            return 0;  
        }

        
        static class Pair {
            TreeNode node;
            int depth;

            Pair(TreeNode n, int d) {
                node = n;
                depth = d;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);  
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);  
        root1.right.right = new TreeNode(7);  
        System.out.println("Test Case 1: Minimum Depth = " + sol.minDepth(root1));  // Expected: 2 (path: 3 -> 9)

        TreeNode root2 = new TreeNode(1);
        System.out.println("Test Case 2: Minimum Depth = " + sol.minDepth(root2));  // Expected: 1

        TreeNode root3 = null;
        System.out.println("Test Case 3: Minimum Depth = " + sol.minDepth(root3));  // Expected: 0

        TreeNode root4 = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.right.right = new TreeNode(4);
        root4.right.right.right = new TreeNode(5);
        root4.right.right.right.right = new TreeNode(6);
        System.out.println("Test Case 4: Minimum Depth = " + sol.minDepth(root4));  // Expected: 5 

        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);  
        root5.right.right = new TreeNode(5);  
        System.out.println("Test Case 5: Minimum Depth = " + sol.minDepth(root5));  // Expected: 3 
        
    }
}
