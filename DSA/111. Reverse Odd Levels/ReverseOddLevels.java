import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class ReverseOddLevels {

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        dfs(root.left, root.right, 1);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return;

        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }

    public void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();
        }
    }

    public TreeNode buildPerfectTree(int[] values) {
        if (values.length == 0) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < values.length) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(values[i++]);
            queue.offer(node.left);
            if (i < values.length) {
                node.right = new TreeNode(values[i++]);
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ReverseOddLevels solver = new ReverseOddLevels();

        int[] values1 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root1 = solver.buildPerfectTree(values1);
        System.out.println("Before reversing odd levels:");
        solver.printLevelOrder(root1);
        solver.reverseOddLevels(root1);
        System.out.println("After reversing odd levels:");
        solver.printLevelOrder(root1);

        int[] values2 = {10, 20, 30, 40, 50, 60, 70};
        TreeNode root2 = solver.buildPerfectTree(values2);
        System.out.println("\nBefore reversing odd levels:");
        solver.printLevelOrder(root2);
        solver.reverseOddLevels(root2);
        System.out.println("After reversing odd levels:");
        solver.printLevelOrder(root2);
    }
}