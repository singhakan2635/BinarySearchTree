package LeetCodeMedium;

import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSucessorInBSt
{
    List<TreeNode> list;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
    {
        list = new ArrayList<>();
        helper(root);
        for (int i=0;i< list.size()-1;i++)
        {
            if (list.get(i)==p)
                return list.get(i+1);
        }
        return null;

    }
    private void helper(TreeNode root)
    {
        if (root==null)
            return;
        helper(root.left);
        list.add(root);
        helper(root.right);
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p)
    {
        return helper(root,p);
    }
    private TreeNode helper(TreeNode node, TreeNode p)
    {
        if (node==null)
            return null;

        if (node.val<=p.val)
        {
            return helper(node.right,p);
        }
        TreeNode left = helper(node.left,p);
        if (left!=null)
            return left;
        else return node;
    }
}
