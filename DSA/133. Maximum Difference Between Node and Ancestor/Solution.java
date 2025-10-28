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
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode node, int min, int max) {
        if (node == null) return;
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
        int newMin = Math.min(min, node.val);
        int newMax = Math.max(max, node.val);
        dfs(node.left, newMin, newMax);
        dfs(node.right, newMin, newMax);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root1 = new TreeNode(8,
            new TreeNode(3,
                new TreeNode(1),
                new TreeNode(6,
                    new TreeNode(4),
                    new TreeNode(7)
                )
            ),
            new TreeNode(10,
                null,
                new TreeNode(14,
                    new TreeNode(13),
                    null
                )
            )
        );
        System.out.println("Test Case 1: " + sol.maxAncestorDiff(root1)); // Should print 7

        sol.maxDiff = 0;

        TreeNode root2 = new TreeNode(1,
            null,
            new TreeNode(2,
                null,
                new TreeNode(0,
                    null,
                    new TreeNode(3)
                )
            )
        );
        System.out.println("Test Case 2: " + sol.maxAncestorDiff(root2)); // Should print 3

        sol.maxDiff = 0;

        TreeNode root3 = new TreeNode(2,
            new TreeNode(4,
                new TreeNode(1),
                null
            ),
            new TreeNode(3)
        );
        System.out.println("Test Case 3: " + sol.maxAncestorDiff(root3)); // Should print 3

        sol.maxDiff = 0;

        TreeNode root4 = new TreeNode(5);
        System.out.println("Test Case 4: " + sol.maxAncestorDiff(root4)); // Should print 0
    }
}
