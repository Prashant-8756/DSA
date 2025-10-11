import java.util.*;

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
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxDiameter;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Test Case 1: " + solution.diameterOfBinaryTree(root1)); // Expected: 3
        
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);
        root2.right.right.right.right = new TreeNode(5);
        System.out.println("Test Case 2: " + solution.diameterOfBinaryTree(root2)); // Expected: 4
        
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3: " + solution.diameterOfBinaryTree(root3)); // Expected: 0
        
        System.out.println("Test Case 4: " + solution.diameterOfBinaryTree(null)); // Expected: 0
        
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
        root5.right.left = new TreeNode(6);
        root5.right.right = new TreeNode(7);
        System.out.println("Test Case 5: " + solution.diameterOfBinaryTree(root5)); // Expected: 4
    }
}
