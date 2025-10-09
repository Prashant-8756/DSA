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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTreeHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBinaryTreeHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        root.left = constructMaximumBinaryTreeHelper(nums, start, maxIndex - 1);
        
        root.right = constructMaximumBinaryTreeHelper(nums, maxIndex + 1, end);
        
        return root;
    }
}

public class MaximumBinaryTree {
    
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
    
    private static void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, result);
        result.add(root.val);
        inorderHelper(root.right, result);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {3, 2, 1, 6, 0, 5};
        TreeNode root1 = solution.constructMaximumBinaryTree(nums1);
        System.out.println("Test Case 1 - Inorder Traversal:");
        printInorder(root1);
        System.out.println();
        System.out.println("Expected inorder: 2 1 3 0 6 5");
        System.out.println("Actual inorder: " + inorderTraversal(root1));
        System.out.println();
        
        int[] nums2 = {3, 2, 1};
        TreeNode root2 = solution.constructMaximumBinaryTree(nums2);
        System.out.println("Test Case 2 - Inorder Traversal:");
        printInorder(root2);
        System.out.println();
        System.out.println("Expected inorder: 1 2 3");
        System.out.println("Actual inorder: " + inorderTraversal(root2));
        System.out.println();
        
        int[] nums3 = {1};
        TreeNode root3 = solution.constructMaximumBinaryTree(nums3);
        System.out.println("Test Case 3 - Inorder Traversal:");
        printInorder(root3);
        System.out.println();
        System.out.println("Expected inorder: 1");
        System.out.println("Actual inorder: " + inorderTraversal(root3));
        System.out.println();
        
        int[] nums4 = {};
        TreeNode root4 = solution.constructMaximumBinaryTree(nums4);
        System.out.println("Test Case 4 - Empty array:");
        System.out.println("Root is null: " + (root4 == null));
        System.out.println();
    }
}
