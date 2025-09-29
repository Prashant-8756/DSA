import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
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
        LevelOrderTraversal solution = new LevelOrderTraversal();

        Integer[] treeArr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = buildTree(treeArr1);
        System.out.println("Level Order Traversal of tree 1: " + solution.levelOrder(root1));

        Integer[] treeArr2 = {1};
        TreeNode root2 = buildTree(treeArr2);
        System.out.println("Level Order Traversal of tree 2: " + solution.levelOrder(root2));

        Integer[] treeArr3 = {};
        TreeNode root3 = buildTree(treeArr3);
        System.out.println("Level Order Traversal of tree 3: " + solution.levelOrder(root3));

        Integer[] treeArr4 = {1, 2, null, 3, null, 4};
        TreeNode root4 = buildTree(treeArr4);
        System.out.println("Level Order Traversal of tree 4: " + solution.levelOrder(root4));
    }
}
