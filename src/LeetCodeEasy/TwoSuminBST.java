package LeetCodeEasy;

import BSTBuilder.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSuminBST
{
    public boolean findTarget(TreeNode root, int k)
    {
        if (root==null)
            return false;
        Set<Integer> set = new HashSet<>();
        return helper(root,k,set);

    }
    private boolean helper(TreeNode node, int k,Set<Integer> set)
    {
        if (node==null)
            return false;
        if (set.contains(k-node.val))
            return true;
        set.add(node.val);
        return helper(node.left,k,set) || helper(node.right,k,set);

    }
}
