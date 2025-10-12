import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left == null && node.right == null) {
                    return depth;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        
        return depth;
    }
}

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(3);
        System.out.println("Test Case 1 - Single node: Expected 1, Actual: " + solution.minDepth(root1));
        
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        System.out.println("Test Case 2 - Left child only: Expected 2, Actual: " + solution.minDepth(root2));
        
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        System.out.println("Test Case 3 - Balanced tree: Expected 3, Actual: " + solution.minDepth(root3));
        
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(3);
        root4.right.right.right = new TreeNode(4);
        System.out.println("Test Case 4 - Skewed right: Expected 4, Actual: " + solution.minDepth(root4));
        
        System.out.println("Test Case 5 - Null tree: Expected 0, Actual: " + solution.minDepth(null));
    }
}
