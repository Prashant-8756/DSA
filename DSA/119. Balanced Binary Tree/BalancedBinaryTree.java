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
    private boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        balanced = true; 
        height(root);
        return balanced;
    }
    
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1; 
        
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1; 
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
            return -1; 
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test 1 - Balanced: " + solution.isBalanced(root1)); // Expected: true
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println("Test 2 - Unbalanced: " + solution.isBalanced(root2)); // Expected: false
        
        TreeNode root3 = null;
        System.out.println("Test 3 - Empty: " + solution.isBalanced(root3)); // Expected: true
        
        TreeNode root4 = new TreeNode(1);
        System.out.println("Test 4 - Single Node: " + solution.isBalanced(root4)); // Expected: true
        
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.left.left = new TreeNode(3);
        root5.left.left.left = new TreeNode(4);
        root5.left.left.left.left = new TreeNode(5);
        System.out.println("Test 5 - Skewed: " + solution.isBalanced(root5)); // Expected: false
    }
}
