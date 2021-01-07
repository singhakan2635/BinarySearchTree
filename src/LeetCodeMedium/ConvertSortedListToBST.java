package LeetCodeMedium;

import BSTBuilder.ListNode;
import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBST
{
    List<Integer> list;
    public TreeNode sortedListToBST(ListNode head)
    {
        if (head==null)
            return null;

        list = new ArrayList<>();
        while (head!=null)
        {
            list.add(head.val);
            head = head.next;
        }
        return helper(0, list.size()-1);

    }
    private TreeNode helper(int start, int end)
    {
        if (start>end)
            return null;
        int mid = (start+end)/2;
        if (list.get(mid)==null)
            return null;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(start,mid-1);
        root.right = helper(mid+1,end);
        return root;
    }
    ListNode head;
    public TreeNode sortedListToBST2(ListNode head)
    {
        if (head==null)
            return null;
        this.head =head;
        int size = getSize(this.head);
        return converttoBST(0,size-1);
    }

    private int getSize(ListNode head)
    {
        ListNode curr = head;
        int c =0;
        while (curr!=null)
        {
            c+=1;
            curr = curr.next;
        }
        return c;
    }
    private TreeNode converttoBST(int start,int end)
    {
        if (start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode left = converttoBST(0,mid-1);

        TreeNode root = new TreeNode(this.head.val);
        root.left = left;
        this.head = this.head.next;
        root.right = converttoBST(mid+1,end);
        return root;
    }
}
