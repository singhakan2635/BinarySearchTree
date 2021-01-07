package LeetCodeMedium;

public class InorderSuccessor2
{
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    public Node inorderSuccessor(Node node)
    {
        if (node.right!=null)
            return getLeftNode(node.right);
        else
            return getParentNode(node);

    }
    private Node getLeftNode(Node node)
    {
        if (node.left!=null)
            return getLeftNode(node.left);
        else return node;
    }
    private Node getParentNode(Node node)
    {
        Node par = node.parent;
        while (par!=null && par.val<node.val)
        {
            par = par.parent;
        }
        return par;
    }
}
