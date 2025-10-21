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

public class SmallestStringFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, new StringBuilder());
    }

    private String dfs(TreeNode node, StringBuilder path) {
        if (node == null) {
            return "~"; 
        }
        path.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            
            return new StringBuilder(path).reverse().toString();
        }
        String left = dfs(node.left, new StringBuilder(path));
        String right = dfs(node.right, new StringBuilder(path));
        return left.compareTo(right) < 0 ? left : right;
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();
            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        SmallestStringFromLeaf solution = new SmallestStringFromLeaf();

        Integer[] arr1 = {0, 1, 2, 3, 4, 3, 4};
        TreeNode root1 = buildTree(arr1);
        System.out.println("Test Case 1: " + solution.smallestFromLeaf(root1)); // Expected: "dba"

        Integer[] arr2 = {25};
        TreeNode root2 = buildTree(arr2);
        System.out.println("Test Case 2: " + solution.smallestFromLeaf(root2)); // Expected: "z"

        Integer[] arr3 = {0, null, 1};
        TreeNode root3 = buildTree(arr3);
        System.out.println("Test Case 3: " + solution.smallestFromLeaf(root3)); // Expected: "ba"

        Integer[] arr4 = {2, 2, 1, null, 1, 0, null, null, 0};
        TreeNode root4 = buildTree(arr4);
        System.out.println("Test Case 4: " + solution.smallestFromLeaf(root4)); // Expected: "abc" or similar, depending on paths
    }
}
