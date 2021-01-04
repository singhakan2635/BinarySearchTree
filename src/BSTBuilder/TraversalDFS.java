package BSTBuilder;

public class TraversalDFS
{
    public void inorder(TreeNode node)
    {
        if (node==null)
            return;
        inorder(node.left);
        System.out.print(node.val+" ");
        inorder(node.right);
    }
}
