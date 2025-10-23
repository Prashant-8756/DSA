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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }
    
    private TreeNode dfs(TreeNode node, int currentSum, int limit) {
        if (node == null) {
            return null;
        }
        
        currentSum += node.val;
        
        if (node.left == null && node.right == null) {
            return currentSum >= limit ? node : null;
        }
        
        node.left = dfs(node.left, currentSum, limit);
        node.right = dfs(node.right, currentSum, limit);
        
        if (node.left == null && node.right == null && currentSum < limit) {
            return null;
        }
        
        return node;
    }
}

public class Main {
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(-99, new TreeNode(12), new TreeNode(13))),
            new TreeNode(3, new TreeNode(-99), new TreeNode(7, new TreeNode(14), null))
        );
        TreeNode result1 = solution.sufficientSubset(root1, 1);
        System.out.print("Test Case 1: ");
        printTree(result1);
        
        TreeNode root2 = new TreeNode(5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );
        TreeNode result2 = solution.sufficientSubset(root2, 22);
        System.out.print("Test Case 2: ");
        printTree(result2);
        
        TreeNode root3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode result3 = solution.sufficientSubset(root3, 10);
        System.out.print("Test Case 3: ");
        printTree(result3);
        
        TreeNode root4 = new TreeNode(10);
        TreeNode result4 = solution.sufficientSubset(root4, 10);
        System.out.print("Test Case 4: ");
        printTree(result4);
        
        TreeNode root5 = new TreeNode(5);
        TreeNode result5 = solution.sufficientSubset(root5, 10);
        System.out.print("Test Case 5: ");
        printTree(result5);
    }
}
