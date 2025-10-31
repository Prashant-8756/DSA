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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        
        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        
        return sum;
    }
}

public class RangeSumBSTTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(10,
            new TreeNode(5, new TreeNode(3), new TreeNode(7)),
            new TreeNode(15, null, new TreeNode(18))
        );
        int result1 = solution.rangeSumBST(root1, 7, 15);
        System.out.println("Test Case 1: Expected 32, Got " + result1 + " - " + (result1 == 32 ? "PASS" : "FAIL"));
        
        TreeNode root2 = new TreeNode(10,
            new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)),
            new TreeNode(15, new TreeNode(13), new TreeNode(18))
        );
        int result2 = solution.rangeSumBST(root2, 6, 10);
        System.out.println("Test Case 2: Expected 23, Got " + result2 + " - " + (result2 == 23 ? "PASS" : "FAIL"));
        
        TreeNode root3 = new TreeNode(10,
            new TreeNode(5, new TreeNode(3), new TreeNode(7)),
            new TreeNode(15, null, new TreeNode(18))
        );
        int result3 = solution.rangeSumBST(root3, 20, 25);
        System.out.println("Test Case 3: Expected 0, Got " + result3 + " - " + (result3 == 0 ? "PASS" : "FAIL"));
        
        TreeNode root4 = new TreeNode(10);
        int result4 = solution.rangeSumBST(root4, 10, 10);
        System.out.println("Test Case 4: Expected 10, Got " + result4 + " - " + (result4 == 10 ? "PASS" : "FAIL"));
        
        TreeNode root5 = null;
        int result5 = solution.rangeSumBST(root5, 1, 10);
        System.out.println("Test Case 5: Expected 0, Got " + result5 + " - " + (result5 == 0 ? "PASS" : "FAIL"));
    }
}
