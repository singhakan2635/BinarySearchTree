package LeetCodeEasy;

import BSTBuilder.TreeNode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CloestBinaryTreeValue
{
    double ans;
    public int closestValue(TreeNode root, double target)
    {
        if (root.right==null && root.right==null)
            return root.val;
        ans=-1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
        helper(root,target,heap);
        if (ans==-1 && !heap.isEmpty())
            ans = heap.poll();
        return (int)ans;
    }
    private void helper(TreeNode node, double target,PriorityQueue<Integer> heap)
    {
        if (node==null)
            return;
        if (node.val==target || node.val==Math.round(target))
            ans = target;
        //if (node.val<=target || node.val==Math.round(target))
        heap.add(node.val);
        if (node.val>target)
            helper(node.left,target,heap);
        if (node.val<target)
            helper(node.right,target,heap);

    }
}
