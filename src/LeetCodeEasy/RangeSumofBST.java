package LeetCodeEasy;

import BSTBuilder.TreeNode;

public class RangeSumofBST
{
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high)
    {
        sum=0;
        if (root==null) return sum;
        helper(root,low,high);
        return sum;

    }
    private void helper(TreeNode node, int low,int high)
    {
        if (node!=null)
        {
            int val = node.val;
            if (val>=low && val<=high)
                sum +=val;
            if (low<node.val)
                helper(node.left,low,high);
            if (node.val<high)
                helper(node.right,low,high);
        }
    }
}
