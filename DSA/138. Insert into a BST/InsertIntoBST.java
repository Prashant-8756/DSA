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

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        InsertIntoBST solution = new InsertIntoBST();

        TreeNode root1 = null;
        root1 = solution.insertIntoBST(root1, 5);
        System.out.print("Test Case 1 (insert 5 into empty tree): ");
        solution.inorderTraversal(root1);
        System.out.println(); // Expected: 5

        TreeNode root2 = new TreeNode(4);
        root2 = solution.insertIntoBST(root2, 2);
        root2 = solution.insertIntoBST(root2, 7);
        System.out.print("Test Case 2 (insert 2 and 7 into [4]): ");
        solution.inorderTraversal(root2);
        System.out.println(); // Expected: 2 4 7

        TreeNode root3 = new TreeNode(4);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(7);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(3);
        root3 = solution.insertIntoBST(root3, 5);
        System.out.print("Test Case 3 (insert 5 into [4,2,7,1,3]): ");
        solution.inorderTraversal(root3);
        System.out.println(); // Expected: 1 2 3 4 5 7
    }
}
