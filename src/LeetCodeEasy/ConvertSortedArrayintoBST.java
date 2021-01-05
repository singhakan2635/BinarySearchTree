package LeetCodeEasy;

import BSTBuilder.TreeNode;

public class ConvertSortedArrayintoBST
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        TreeNode node=null;
        return helper(node,nums,0,nums.length-1);
    }
    private TreeNode helper(TreeNode root,int[] nums,int start,int end)
    {
        if (start>end)
            return null;
        int mid = (start+end)/2;
        if (root==null)
        {
            root = new TreeNode(nums[mid]);
        }
        root.left = helper(root.left,nums,start,mid-1);
        root.right = helper(root.right,nums,mid+1,end);
        return root;
    }
}
