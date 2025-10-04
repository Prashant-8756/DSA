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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        dfs(root, val, depth, 1);
        return root;
    }
    
    private void dfs(TreeNode node, int val, int depth, int currDepth) {
        if (node == null) return;
        if (currDepth == depth - 1) {
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            node.left.left = tempLeft;
            node.right.right = tempRight;
            return;
        }
        dfs(node.left, val, depth, currDepth + 1);
        dfs(node.right, val, depth, currDepth + 1);
    }
}

class Main {
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                result.add(null);
            }
        }
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        System.out.println(result);
    }
    
    public static TreeNode buildTree(int[] vals) {
        if (vals == null || vals.length == 0) return null;
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < vals.length) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (i < vals.length && vals[i] != Integer.MIN_VALUE) {
                    node.left = new TreeNode(vals[i]);
                }
                i++;
                if (i < vals.length && vals[i] != Integer.MIN_VALUE) {
                    node.right = new TreeNode(vals[i]);
                }
                i++;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] tree1 = {4,2,6,3,1,5};
        TreeNode root1 = buildTree(tree1);
        TreeNode result1 = solution.addOneRow(root1, 1, 2);
        System.out.print("Test Case 1 - After adding row: ");
        printTree(result1);
        
        int[] tree2 = {4,2,Integer.MIN_VALUE,3,1};
        TreeNode root2 = buildTree(tree2);
        TreeNode result2 = solution.addOneRow(root2, 1, 3);
        System.out.print("Test Case 2 - After adding row: ");
        printTree(result2);
        
        int[] tree3 = {4,2,6,3,1,5};
        TreeNode root3 = buildTree(tree3);
        TreeNode result3 = solution.addOneRow(root3, 1, 1);
        System.out.print("Test Case 3 - After adding row: ");
        printTree(result3);
        
        int[] tree4 = {4};
        TreeNode root4 = buildTree(tree4);
        TreeNode result4 = solution.addOneRow(root4, 1, 2);
        System.out.print("Test Case 4 - After adding row: ");
        printTree(result4);
    }
}
