import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MinimumAbsoluteDifferenceInBST {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST solution = new MinimumAbsoluteDifferenceInBST();

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        System.out.println("Test Case 1: " + solution.getMinimumDifference(root1)); // Expected: 1

        solution = new MinimumAbsoluteDifferenceInBST();

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(20);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(8);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(25);
        System.out.println("Test Case 2: " + solution.getMinimumDifference(root2)); // Expected: 2

        solution = new MinimumAbsoluteDifferenceInBST();

        TreeNode root3 = new TreeNode(5);
        System.out.println("Test Case 3: " + solution.getMinimumDifference(root3)); // Expected: Integer.MAX_VALUE (but in practice, since no diff, we can handle as 0 or note it)

        solution = new MinimumAbsoluteDifferenceInBST();

        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(5);
        System.out.println("Test Case 4: " + solution.getMinimumDifference(root4)); // Expected: 5
    }
}
