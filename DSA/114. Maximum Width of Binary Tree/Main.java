import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private static class NodeInfo {
        TreeNode node;
        int index;
        NodeInfo(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int maxIndex = 0;
            for (int i = 0; i < size; i++) {
                NodeInfo curr = queue.poll();
                TreeNode node = curr.node;
                int index = curr.index;
                maxIndex = Math.max(maxIndex, index);
                if (node.left != null) {
                    queue.offer(new NodeInfo(node.left, index * 2));
                }
                if (node.right != null) {
                    queue.offer(new NodeInfo(node.right, index * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, maxIndex - minIndex + 1);
        }
        return maxWidth;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(9);
        root1.left.left.right = new TreeNode(6);
        root1.right.right.right = new TreeNode(7);
        System.out.println("Test Case 1: " + solution.widthOfBinaryTree(root1)); // Expected: 8

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        System.out.println("Test Case 2: " + solution.widthOfBinaryTree(root2)); // Expected: 2

        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3: " + solution.widthOfBinaryTree(root3)); // Expected: 1

        System.out.println("Test Case 4: " + solution.widthOfBinaryTree(null)); // Expected: 0

        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(3);
        root5.right.right = new TreeNode(5);
        root5.right.right.right = new TreeNode(7);
        System.out.println("Test Case 5: " + solution.widthOfBinaryTree(root5)); // Expected: 1
    }
}
