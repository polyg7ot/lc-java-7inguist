package com.idiotleon.leetcode.lvl4.lc0230;

import java.util.ArrayDeque;
import java.util.Deque;

import com.idiotleon.util.Constant;
import com.idiotleon.util.data_structure.tree.TreeNode;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">LC0230</a>
 * <p>
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * <p>
 * The follow-up question makes this problem a 4-star.
 * What if the BST is modified (insert/delete operations)
 * often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0InorderIteration {
    public int kthSmallest(TreeNode root, int k) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);

        while (!stack.isEmpty()) {
            final TreeNode top = stack.pop();
            if (--k == 0) {
                return top.val;
            }

            pushLeft(top.right, stack);
        }

        return Integer.MIN_VALUE;
    }

    private void pushLeft(TreeNode node, Deque<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}