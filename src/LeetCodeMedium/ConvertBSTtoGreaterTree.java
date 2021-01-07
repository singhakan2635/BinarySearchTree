package LeetCodeMedium;

import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTtoGreaterTree
{
    int sum;
    List<Integer> list;
    List<Integer> list2;
    public TreeNode convertBST(TreeNode root)
    {
        sum=0;
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        firstInorder(root);
        for (int i=0;i<list.size();i++)
        {
            if (i==0)
            {
                list2.add(sum);
            }
            else
            {
                list2.add(list2.get(i-1)- list.get(i-1));
            }
        }
        System.out.println("list is "+list2);
        return helper(0, list2.size()-1);
    }
    private void firstInorder(TreeNode node)
    {
        if (node==null)
            return;
        firstInorder(node.left);
        sum+=node.val;
        list.add(node.val);
        firstInorder(node.right);
    }
    private TreeNode helper(int start,int end)
    {
        if (start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(list2.get(mid));
        root.left = helper(start,mid-1);
        root.right = helper(mid+1,end);
        return root;
    }

}
