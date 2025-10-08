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
    private Map<Integer, Integer> inorderMap;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        postIndex = postorder.length - 1;
        return helper(inorder, 0, inorder.length - 1, postorder);
    }
    
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder) {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = postorder[postIndex];
        postIndex--;
        
        TreeNode root = new TreeNode(rootVal);
        
        int inRootIndex = inorderMap.get(rootVal);
        
        root.right = helper(inorder, inRootIndex + 1, inEnd, postorder);
        root.left = helper(inorder, inStart, inRootIndex - 1, postorder);
        
        return root;
    }
}

class TreePrinter {
    public static void printInorder(TreeNode root) {
        if (root == null) {
            System.out.print("null");
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    
    public static void printPostorder(TreeNode root) {
        if (root == null) {
            System.out.print("null");
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        System.out.println("Test Case 1:");
        System.out.print("Expected Inorder: ");
        for (int val : inorder1) System.out.print(val + " ");
        System.out.println();
        System.out.print("Actual Inorder:  ");
        TreePrinter.printInorder(root1);
        System.out.println();
        System.out.print("Expected Postorder: ");
        for (int val : postorder1) System.out.print(val + " ");
        System.out.println();
        System.out.print("Actual Postorder:  ");
        TreePrinter.printPostorder(root1);
        System.out.println("\n" + (verify(root1, inorder1, postorder1) ? "PASS" : "FAIL") + "\n");
        
        int[] inorder2 = {1};
        int[] postorder2 = {1};
        TreeNode root2 = solution.buildTree(inorder2, postorder2);
        System.out.println("Test Case 2:");
        System.out.print("Expected Inorder: 1 ");
        System.out.println();
        System.out.print("Actual Inorder:   ");
        TreePrinter.printInorder(root2);
        System.out.println();
        System.out.print("Expected Postorder: 1 ");
        System.out.println();
        System.out.print("Actual Postorder:   ");
        TreePrinter.printPostorder(root2);
        System.out.println("\n" + (verify(root2, inorder2, postorder2) ? "PASS" : "FAIL") + "\n");
        
        int[] inorder3 = {};
        int[] postorder3 = {};
        TreeNode root3 = solution.buildTree(inorder3, postorder3);
        System.out.println("Test Case 3 (Empty): " + (root3 == null ? "PASS" : "FAIL"));
    }
    
    private static boolean verify(TreeNode root, int[] expectedInorder, int[] expectedPostorder) {
        List<Integer> actualInorder = new ArrayList<>();
        inorderTraversal(root, actualInorder);
        
        List<Integer> actualPostorder = new ArrayList<>();
        postorderTraversal(root, actualPostorder);
        
        if (actualInorder.size() != expectedInorder.length) return false;
        if (actualPostorder.size() != expectedPostorder.length) return false;
        
        for (int i = 0; i < expectedInorder.length; i++) {
            if (actualInorder.get(i) != expectedInorder[i]) return false;
        }
        for (int i = 0; i < expectedPostorder.length; i++) {
            if (actualPostorder.get(i) != expectedPostorder[i]) return false;
        }
        return true;
    }
    
    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
    
    private static void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
