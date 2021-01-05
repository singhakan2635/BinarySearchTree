package LeetCodeEasy;

import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestBinaryTree2
{
    public int closestValue(TreeNode root, double target)
    {
        List<Integer> nums = new ArrayList<>();
        inorder(root,nums);
        int ans = Collections.min(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
        return ans;
    }
    private void inorder(TreeNode root, List<Integer> nums)
    {
        if (root==null) return;
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
}
