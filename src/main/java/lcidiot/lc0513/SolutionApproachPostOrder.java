/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
package main.java.lcidiot.lc0513;

import main.java.lcidiot.utils.TreeNode;

public class SolutionApproachPostOrder {
    private int deepest;
    private int leftmost;
    
    public int findBottomLeftValue(TreeNode root) {
        deepest = 0;
        leftmost = root.val;
        
        postorder(root, 0);
        return leftmost;
    }
    
    private void postorder(TreeNode node, int depth){
        if(node == null) return;
    
        postorder(node.left, depth + 1);
        postorder(node.right, depth + 1);
        if(depth > deepest){
            deepest = depth;
            /* only to update the leftmost,
            * when it reaches the next level.
            * And only update once (per level),
            * because post order automatically starts with 
            * the leftmost element in that level
            */
            leftmost = node.val;
        }
    }
}