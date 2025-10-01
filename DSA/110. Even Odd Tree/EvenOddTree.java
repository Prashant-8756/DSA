import java.util.*;

public class EvenOddTree {
    
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prevVal = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                
                if (level % 2 == 0) {
                    if (val % 2 == 0 || val <= prevVal) return false;
                } else {
                    if (val % 2 != 0 || val >= prevVal) return false;
                }
                
                prevVal = val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        
        return true;
    }
    
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    
    public static void main(String[] args) {
        EvenOddTree solution = new EvenOddTree();
        
        Integer[] tree1 = {1,10,4,3,null,7,9,12,8,6,null,null,2};
        TreeNode root1 = buildTree(tree1);
        System.out.println("Test case 1: " + solution.isEvenOddTree(root1)); // Expected: true
        
        Integer[] tree2 = {5,9,1,3,5,7};
        TreeNode root2 = buildTree(tree2);
        System.out.println("Test case 2: " + solution.isEvenOddTree(root2)); // Expected: false
        
        Integer[] tree3 = {1,4,2,3,3,7};
        TreeNode root3 = buildTree(tree3);
        System.out.println("Test case 3: " + solution.isEvenOddTree(root3)); // Expected: false
        
        Integer[] tree4 = {1};
        TreeNode root4 = buildTree(tree4);
        System.out.println("Test case 4: " + solution.isEvenOddTree(root4)); // Expected: true
    }
}
