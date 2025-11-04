class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        LCABST solution = new LCABST();
        
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        
        TreeNode p = root.left; // 2
        TreeNode q = root.right; // 8
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Test 1 - LCA of 2 and 8: " + (lca != null ? lca.val : "null") + " (Expected: 6)");
        
        p = root.left.right.left; // 3
        q = root.left.right.right; // 5
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Test 2 - LCA of 3 and 5: " + (lca != null ? lca.val : "null") + " (Expected: 4)");
        
        p = root.left.left; // 0
        q = root.left.right; // 4
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Test 3 - LCA of 0 and 4: " + (lca != null ? lca.val : "null") + " (Expected: 2)");
        
        p = root.left; // 2
        q = root.left.right.left; // 3
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Test 4 - LCA of 2 and 3: " + (lca != null ? lca.val : "null") + " (Expected: 2)");
        
        p = root.left.left; // 0
        q = root.right.right; // 9
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Test 5 - LCA of 0 and 9: " + (lca != null ? lca.val : "null") + " (Expected: 6)");
    }
}
