package LeetCodeMedium;

import BSTBuilder.TreeNode;

public class SerializeAndDeserialize
{
    StringBuilder sb;
    public String serialize(TreeNode root)
    {
        sb = new StringBuilder();
        if (root==null)
            return "";
        helper(root);
        return sb.toString();
    }
    private void helper(TreeNode node)
    {
        if (node==null)
            return;
        helper(node.left);
        sb.append(node.val).append(" ");
        helper(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        String[] arr = data.split(" ");

        return deserilixe(arr,0,arr.length-1);

    }
    private TreeNode deserilixe(String[] arr,int start,int end)
    {
        if (start>end)
            return null;
        int mid = (start+end)/2;
        if (arr[mid].equals(null) || arr[mid].equals(""))
        {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[mid]));
        root.left = deserilixe(arr,start,mid-1);
        root.right = deserilixe(arr,mid+1,end);
        return root;
    }
}
