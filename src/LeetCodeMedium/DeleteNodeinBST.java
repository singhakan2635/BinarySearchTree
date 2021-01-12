package LeetCodeMedium;

import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeinBST
{
    List<TreeNode> list;
    public TreeNode deleteNode(TreeNode root, int key)
    {
        list = new ArrayList<>();
        helper(root);
        for (int i=0;i< list.size()-1;i++)
        {
            if (list.get(i).val==key)
            {
                TreeNode curr = list.get(i);
                TreeNode next = list.get(i+1);
                if (curr.left!=null && curr.right==next)
                {
                    next.left = curr.left;
                    curr = next;
                    return root;
                }
                else if (curr.right!=null && curr.left==next)
                {
                    next.right = curr.right;
                    curr = next;
                    return root;
                }
            }
        }
        return root;
    }
    private void helper(TreeNode node)
    {
        if (node==null)
            return;
        helper(node.left);
        list.add(node);
        helper(node.right);


    }
}
