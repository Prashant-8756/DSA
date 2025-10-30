class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ValidateBST {
    private long prev = Long.MIN_VALUE; 

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        if (!isValidBST(root.left)) return false;
        if (root.val <= prev) return false;
        prev = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        ValidateBST validator = new ValidateBST();
        
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test 1 (Valid BST): " + validator.isValidBST(root1)); // true
        
        validator.prev = Long.MIN_VALUE;
        
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test 2 (Invalid BST): " + validator.isValidBST(root2)); // false
        
        validator.prev = Long.MIN_VALUE;
        
        System.out.println("Test 3 (Empty tree): " + validator.isValidBST(null)); // true
        
        validator.prev = Long.MIN_VALUE;
        
        TreeNode root4 = new TreeNode(1);
        System.out.println("Test 4 (Single node): " + validator.isValidBST(root4)); // true
        
        validator.prev = Long.MIN_VALUE;
        
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(1);
        System.out.println("Test 5 (Duplicate values): " + validator.isValidBST(root5)); // false
    }
}
