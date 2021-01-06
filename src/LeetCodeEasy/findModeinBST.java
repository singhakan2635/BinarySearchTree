package LeetCodeEasy;

import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findModeinBST
{
    int max;
    HashMap<Integer,Integer> map;
    public int[] findMode(TreeNode root)
    {
        max=0;
        map = new HashMap<>();
        helper(root);
        List<Integer> list = new ArrayList<>();
        System.out.println("max is "+max);
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if (entry.getValue()==max)
            {
                list.add(entry.getKey());
            }
            else
                continue;

        }
        int[] arr = list.stream().mapToInt(i->i).toArray();
        return arr;

    }
    private void helper(TreeNode node)
    {
        if (node==null)
            return;

        map.put(node.val,map.getOrDefault(node.val,0)+1);
        max = Math.max(max,map.get(node.val));
        helper(node.left);
        helper(node.right);
    }
}
