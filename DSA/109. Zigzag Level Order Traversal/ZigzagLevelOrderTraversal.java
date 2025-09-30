import java.util.*;

public class ZigzagLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
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
        Integer[] treeArr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = buildTree(treeArr1);
        System.out.println("Zigzag Level Order Traversal of tree 1:");
        System.out.println(zigzagLevelOrder(root1));
        // Expected output: [[3], [20, 9], [15, 7]]

        Integer[] treeArr2 = {1, 2, 3, 4, null, null, 5};
        TreeNode root2 = buildTree(treeArr2);
        System.out.println("Zigzag Level Order Traversal of tree 2:");
        System.out.println(zigzagLevelOrder(root2));
        // Expected output: [[1], [3, 2], [4, 5]]

        Integer[] treeArr3 = {};
        TreeNode root3 = buildTree(treeArr3);
        System.out.println("Zigzag Level Order Traversal of tree 3:");
        System.out.println(zigzagLevelOrder(root3));
        // Expected output: []
    }
}
