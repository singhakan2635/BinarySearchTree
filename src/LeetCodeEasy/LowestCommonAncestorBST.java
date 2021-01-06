package LeetCodeEasy;

import BSTBuilder.TreeNode;

import java.util.*;

public class LowestCommonAncestorBST
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root==p || root==q)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root,null);
        while (!map.containsKey(p) || !map.containsKey(q))
        {
            TreeNode node = queue.poll();
            if (node.left!=null)
            {
                map.put(node.left,node);
                queue.offer(node.left);
            }
            if (node.right!=null)
            {
                map.put(node.right,node);
                queue.offer(node.right);
            }
        }
        HashSet<TreeNode> parents = new HashSet<>();
        while (p!=null)
        {
            parents.add(p);
            p = map.get(p);
        }
        while (!parents.contains(q))
        {
            q = map.get(q);
        }
        return q;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root==p || root==q)
            return root;
        int pval = p.val;
        int qval = q.val;

        while (root!=null)
        {
            int currVal = root.val;
            if (pval>currVal && qval>currVal)
                root=root.right;
            else if (pval<currVal && qval<currVal)
                root = root.left;
            else
                return root;
        }
        return null;
    }
}
