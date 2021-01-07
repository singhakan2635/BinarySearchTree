package LeetCodeMedium;

import BSTBuilder.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InsertIntiBST
{
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        if (root==null)
        {
            root = new TreeNode(val);
            return root;
        }
        return helper(root,val);

    }
    private TreeNode helper(TreeNode node,int val)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty())
        {
            TreeNode curr = queue.poll();
            if (curr.left==null && val<curr.val)
            {
                curr.left = new TreeNode(val);
                return node;
            }
            else if (curr.right==null && val>curr.val)
            {
                curr.right = new TreeNode(val);
                return node;
            }
            /*
            if (curr.left==null && curr.right==null)
            {
                if (val<curr.val)
                {
                    curr.left = new TreeNode(val);
                    return node;
                }
                else
                {
                    curr.right = new TreeNode(val);
                    return node;
                }
            }
            */
            if (val<curr.val)
            {
                queue.offer(curr.left);
            }
            if (val>curr.val)
            {
                queue.offer(curr.right);
            }
        }
        return node;
    }
}
