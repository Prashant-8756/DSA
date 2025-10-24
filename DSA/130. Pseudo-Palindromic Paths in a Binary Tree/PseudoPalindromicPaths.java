import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PseudoPalindromicPaths {
    public int pseudoPalindromicPaths(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int mask) {
        if (node == null) return 0;
        mask ^= (1 << node.val);
        if (node.left == null && node.right == null) {
            return (Integer.bitCount(mask) <= 1) ? 1 : 0;
        }
        return dfs(node.left, mask) + dfs(node.right, mask);
    }

    public static void main(String[] args) {
        PseudoPalindromicPaths solution = new PseudoPalindromicPaths();
        
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(1);
        root1.right.right = new TreeNode(1);
        System.out.println("Test 1: " + solution.pseudoPalindromicPaths(root1)); // Expected: 2
        
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        System.out.println("Test 2: " + solution.pseudoPalindromicPaths(root2)); // Expected: 1
        
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3: " + solution.pseudoPalindromicPaths(root3)); // Expected: 1
        
        TreeNode root4 = new TreeNode(9);
        System.out.println("Test 4: " + solution.pseudoPalindromicPaths(root4)); // Expected: 1
    }
}
