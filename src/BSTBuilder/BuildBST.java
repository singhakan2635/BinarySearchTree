package BSTBuilder;

import java.util.Arrays;

public class BuildBST
{
    public TreeNode root;

    public TreeNode buildBst(Integer[] n)
    {
        TreeNode node =null;
        Arrays.sort(n);
        return contructBST(n,0,n.length-1,node);
    }

    private TreeNode contructBST(Integer[] arr, int start, int end,TreeNode root)
    {
        if (start>end)
            return null;
        int mid = (start+end)/2;

        if (root==null)
        {
            root = new TreeNode(arr[mid]);
        }
        root.left = contructBST(arr,start,mid-1,root.left);
        root.right = contructBST(arr,mid+1,end,root.right);

        return root;
    }
}
