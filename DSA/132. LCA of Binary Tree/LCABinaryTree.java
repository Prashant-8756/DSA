class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root == p || root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
}

public class LCABinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        
        TreeNode p1 = root1.left; // 5
        TreeNode q1 = root1.right; // 1
        TreeNode lca1 = solution.lowestCommonAncestor(root1, p1, q1);
        System.out.println("Test Case 1: LCA of 5 and 1 is " + (lca1 != null ? lca1.val : "null")); // Expected: 3
        
        TreeNode p2 = root1.left; // 5
        TreeNode q2 = root1.left.left; // 6
        TreeNode lca2 = solution.lowestCommonAncestor(root1, p2, q2);
        System.out.println("Test Case 2: LCA of 5 and 6 is " + (lca2 != null ? lca2.val : "null")); // Expected: 5
        
        TreeNode p3 = root1.left.right.left; // 7
        TreeNode q3 = root1.left.right.right; // 4
        TreeNode lca3 = solution.lowestCommonAncestor(root1, p3, q3);
        System.out.println("Test Case 3: LCA of 7 and 4 is " + (lca3 != null ? lca3.val : "null")); // Expected: 2
        
        TreeNode lca4 = solution.lowestCommonAncestor(null, p1, q1);
        System.out.println("Test Case 4: LCA with null root is " + (lca4 != null ? lca4.val : "null")); // Expected: null
        
        TreeNode root5 = new TreeNode(1);
        TreeNode p5 = root5;
        TreeNode q5 = root5;
        TreeNode lca5 = solution.lowestCommonAncestor(root5, p5, q5);
        System.out.println("Test Case 5: LCA of single node is " + (lca5 != null ? lca5.val : "null")); // Expected: 1
    }
}
