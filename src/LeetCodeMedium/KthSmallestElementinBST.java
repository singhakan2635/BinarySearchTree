package LeetCodeMedium;

import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementinBST
{
    List<TreeNode> list;
    public int kthSmallest(TreeNode root, int k)
    {
        list = new ArrayList<>();
        inorder(root);
        return list.get(k-1).val;

    }
    private void inorder(TreeNode node)
    {
        if (node==null)
            return;
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }

    public int kthSmallest2(TreeNode root, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.empty() || curr!=null)
        {
            if (curr!=null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                k--;
                if (k==0)
                    return curr.val;
                curr = curr.right;
            }
        }
        return 0;
    }

}
