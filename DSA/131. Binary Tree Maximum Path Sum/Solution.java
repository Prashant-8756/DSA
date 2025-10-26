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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(1);
        System.out.println("Test Case 1 (Single node): " + solution.maxPathSum(root1)); // Expected: 1

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("Test Case 2 (Positive values): " + solution.maxPathSum(root2)); // Expected: 6 (1+2+3)

        TreeNode root3 = new TreeNode(-10);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        System.out.println("Test Case 3 (LeetCode example): " + solution.maxPathSum(root3)); // Expected: 42 (20+15+7)

        TreeNode root4 = new TreeNode(-3);
        root4.left = new TreeNode(-2);
        root4.right = new TreeNode(-1);
        System.out.println("Test Case 4 (All negative): " + solution.maxPathSum(root4)); // Expected: -1 (the largest single node)
    }
}
