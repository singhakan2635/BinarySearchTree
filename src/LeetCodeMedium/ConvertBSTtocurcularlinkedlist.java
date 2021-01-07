package LeetCodeMedium;

import BSTBuilder.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTtocurcularlinkedlist
{
    List<Node> list;
    public Node treeToDoublyList(Node root)
    {
        if(root==null) return null;
        list = new ArrayList<>();
        inorder(root);
        return convertLl();

    }
    private void inorder(Node node)
    {
        if (node==null)
            return;
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }
    private Node convertLl()
    {
        for (int i=0;i<list.size()-1;i++)
        {
            Node curr = list.get(i);
            Node next = list.get(i+1);
            curr.right = next;
            next.left = curr;
        }
        Node last = list.get(list.size()-1);
        Node curr = list.get(0);
        curr.left = last;
        last.right =curr;
        return curr;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    Node first =null;
    Node last = null;
    public Node treeToDoublyList(Node root)
    {
        if (root==null) return null;
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }
    private void helper(Node node)
    {
        if (node==null)
            return;
        helper(node.left);
        if (last!=null)
        {
            last.right = node;
            node.left = last;
        }
        else
            first = node;
        last = node;
        helper(node.right);
    }
}

