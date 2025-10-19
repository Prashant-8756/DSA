import java.util.ArrayList;
import java.util.List;

public class Main {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();  
            if (root == null) return result;  
            
            List<Integer> currentPath = new ArrayList<>();  
            dfs(root, targetSum, currentPath, result);  
            return result;
        }
        
        private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
            if (node == null) return;  
            
            currentPath.add(node.val);
            remainingSum -= node.val;
            
            if (node.left == null && node.right == null) {
                if (remainingSum == 0) {
                    result.add(new ArrayList<>(currentPath));  
                }
            } else {
                if (node.left != null) {
                    dfs(node.left, remainingSum, currentPath, result);
                }
                if (node.right != null) {
                    dfs(node.right, remainingSum, currentPath, result);
                }
            }
            
            currentPath.remove(currentPath.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        
        List<List<Integer>> result1 = sol.pathSum(root1, 22);
        System.out.println("Test Case 1: " + result1);  // Expected: [[5, 4, 11, 2], [5, 8, 4, 5]]
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        
        List<List<Integer>> result2 = sol.pathSum(root2, 4);
        System.out.println("Test Case 2: " + result2);  // Expected: [[1, 3]]
        
        TreeNode root3 = new TreeNode(1);
        
        List<List<Integer>> result3 = sol.pathSum(root3, 1);
        System.out.println("Test Case 3: " + result3);  // Expected: [[1]]
        
        TreeNode root4 = null;
        
        List<List<Integer>> result4 = sol.pathSum(root4, 0);
        System.out.println("Test Case 4: " + result4);  // Expected: []
    }
}
