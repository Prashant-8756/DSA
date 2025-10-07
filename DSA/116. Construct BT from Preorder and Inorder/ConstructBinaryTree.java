import java.util.*;

// Definition for a binary tree node.
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
    private Map<Integer, Integer> inorderIndexMap;
    private int preIndex = 0; // Global index for preorder traversal (reset per call)

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        preIndex = 0;
        
        return helper(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        int inRootIndex = inorderIndexMap.get(rootVal);
        
        root.left = helper(preorder, inStart, inRootIndex - 1);
        
        root.right = helper(preorder, inRootIndex + 1, inEnd);
        
        return root;
    }
}

public class ConstructBinaryTree {
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.print("Test Case 1 - Inorder Traversal: ");
        printInorder(root1);
        System.out.println(); // Output: 9 3 15 20 7 
        
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.print("Test Case 2 - Inorder Traversal: ");
        printInorder(root2);
        System.out.println(); // Output: 1 
        
        int[] preorder3 = {};
        int[] inorder3 = {};
        TreeNode root3 = solution.buildTree(preorder3, inorder3);
        System.out.print("Test Case 3 - Inorder Traversal: ");
        printInorder(root3);
        System.out.println(); // Output: (nothing)
        
        int[] preorder4 = {1, 2, 3};
        int[] inorder4 = {2, 1, 3};
        TreeNode root4 = solution.buildTree(preorder4, inorder4);
        System.out.print("Test Case 4 - Inorder Traversal: ");
        printInorder(root4);
        System.out.println(); // Output: 2 1 3 
    }
}
