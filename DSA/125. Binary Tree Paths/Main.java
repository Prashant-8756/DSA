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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result;  
            }
            StringBuilder path = new StringBuilder();  
            dfs(root, result, path);
            return result;
        }
        
        private void dfs(TreeNode node, List<String> result, StringBuilder path) {
            int len = path.length();  
            
            if (len > 0) {
                path.append("->");  
            }
            path.append(node.val);  
            
            int currentLen = path.length();  
            
            if (node.left == null && node.right == null) {
                result.add(path.toString());
            } else {
                if (node.left != null) {
                    dfs(node.left, result, path);  
                    path.setLength(currentLen);  
                }
                if (node.right != null) {
                    dfs(node.right, result, path);  
                    path.setLength(currentLen);  
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        
        System.out.println("Test Case 1 Paths: " + sol.binaryTreePaths(root1));
        TreeNode root2 = new TreeNode(1);  // Tree: 1
        System.out.println("Test Case 2 Paths: " + sol.binaryTreePaths(root2));
        TreeNode root3 = null;  // Empty tree
        System.out.println("Test Case 3 Paths: " + sol.binaryTreePaths(root3));
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        System.out.println("Test Case 4 Paths: " + sol.binaryTreePaths(root4));
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(5);
        root5.left.left = new TreeNode(3);
        root5.left.right = new TreeNode(4);
        root5.right.right = new TreeNode(6);
        System.out.println("Test Case 5 Paths: " + sol.binaryTreePaths(root5));
    }
}
