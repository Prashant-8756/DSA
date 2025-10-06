import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parentMap.put(root, null);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        q.offer(target);
        visited.add(target);
        
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            if (distance == k) {
                for (int i = 0; i < size; i++) {
                    result.add(q.poll().val);
                }
                return result;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            
            distance++;
        }
        
        return result; 
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        
        TreeNode target1 = root1.left; // Node 5
        int k1 = 2;
        List<Integer> result1 = solution.distanceK(root1, target1, k1);
        System.out.println("Test Case 1 - Nodes at distance " + k1 + " from target 5: " + result1);
        
        int k2 = 0;
        List<Integer> result2 = solution.distanceK(root1, target1, k2);
        System.out.println("Test Case 2 - Nodes at distance " + k2 + " from target 5: " + result2);
        
        TreeNode root3 = new TreeNode(0);
        TreeNode target3 = root3;
        int k3 = 1;
        List<Integer> result3 = solution.distanceK(root3, target3, k3);
        System.out.println("Test Case 3 - Nodes at distance " + k3 + " from target 0: " + result3);
        
        int k4 = 10;
        List<Integer> result4 = solution.distanceK(root1, target1, k4);
        System.out.println("Test Case 4 - Nodes at distance " + k4 + " from target 5: " + result4);
    }
}
