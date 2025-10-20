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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test 1: " + solution.sumNumbers(root1)); // Expected: 25
        
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test 2: " + solution.sumNumbers(root2)); // Expected: 1
        
        TreeNode root3 = null;
        System.out.println("Test 3: " + solution.sumNumbers(root3)); // Expected: 0
        
        TreeNode root4 = new TreeNode(4, 
            new TreeNode(9, new TreeNode(5), new TreeNode(1)), 
            new TreeNode(0));
        System.out.println("Test 4: " + solution.sumNumbers(root4)); // Expected: 1026
    }
}
