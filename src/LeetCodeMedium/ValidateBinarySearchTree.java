package LeetCodeMedium;

import BSTBuilder.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree
{
    public boolean isValidBST(TreeNode root)
    {
        if (root.left==null && root.right==null)
            return true;

        Queue<Var> queue = new LinkedList<>();
        queue.offer(new Var(root,Long.MIN_VALUE,Long.MAX_VALUE));

        while (!queue.isEmpty())
        {
            Var var = queue.poll();
            if (!(var.node.val>var.lower && var.node.val<var.higher))
            {
                return false;
            }
            if (var.node.left!=null)
                queue.offer(new Var(var.node.left, var.lower,var.node.val));
            if (var.node.right!=null)
                queue.offer(new Var(var.node.right, var.node.val, var.higher));
        }
        return true;
    }
    class Var
    {
        TreeNode node;
        long lower;
        long higher;

        public Var(TreeNode node, long lower, long higher) {
            this.node = node;
            this.lower = lower;
            this.higher = higher;
        }
    }

    public boolean isValidBST2(TreeNode root)
    {
        if (root==null)
            return true;
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean helper(TreeNode node,long low,long high)
    {
        if (node==null)
            return true;
        if (node.val<=low || node.val>=high)
            return false;
        return helper(node.left,low,node.val) && helper(node.right,node.val,high);
    }

}
