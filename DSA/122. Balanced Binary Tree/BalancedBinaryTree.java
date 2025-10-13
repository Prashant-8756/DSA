import java.util.*;  // Not strictly needed, but for potential expansions

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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 0;  // Height of empty tree is 0
        }
        
        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;  // Left subtree is unbalanced
        }
        
        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;  // Right subtree is unbalanced
        }
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;  // Current node is unbalanced
        }
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("Test Case 1: Single Node Tree");
        TreeNode root1 = new TreeNode(3);
        System.out.println("Expected: true, Actual: " + sol.isBalanced(root1));
        System.out.println();
        
        System.out.println("Test Case 2: Balanced Complete Binary Tree");
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Expected: true, Actual: " + sol.isBalanced(root2));
        System.out.println();
        
        System.out.println("Test Case 3: Unbalanced Tree");
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.right = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        root3.left.left.right = new TreeNode(4);
        System.out.println("Expected: false, Actual: " + sol.isBalanced(root3));
        System.out.println();
        
        System.out.println("Test Case 4: Empty Tree");
        System.out.println("Expected: true, Actual: " + sol.isBalanced(null));
        System.out.println();
        
        System.out.println("Test Case 5: Deep Left Subtree (Unbalanced)");
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.left.left = new TreeNode(3);
        root5.left.left.left = new TreeNode(4);
        root5.left.left.left.left = new TreeNode(5);
        System.out.println("Expected: false, Actual: " + sol.isBalanced(root5));
        System.out.println();
    }
}
