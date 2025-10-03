import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0; 

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(6);
        root1.left.left.left = new TreeNode(7);
        root1.right.right.right = new TreeNode(8);

        System.out.println("Deepest Leaves Sum: " + sol.deepestLeavesSum(root1)); // Output: 15

        TreeNode root2 = new TreeNode(1);
        System.out.println("Deepest Leaves Sum: " + sol.deepestLeavesSum(root2)); // Output: 1

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        System.out.println("Deepest Leaves Sum: " + sol.deepestLeavesSum(root3)); // Output: 5
    }
}
