package LeetCodeEasy;

import BSTBuilder.BuildBST;
import BSTBuilder.TraversalDFS;

public class MainClass
{
    public static void main(String[] args) {
        BuildBST bst = new BuildBST();

        /** 938. Range Sum of BST */
        Integer[] t1 = new Integer[]{10,5,15,3,7,13,18,1,null,6};
        bst.root = bst.buildBst(t1);
        TraversalDFS dfs = new TraversalDFS();
        dfs.inorder(bst.root);
        System.out.println();
        System.out.println("Range Sum of BST : ");
        RangeSumofBST rangeSumofBST = new RangeSumofBST();
        System.out.println(rangeSumofBST.rangeSumBST(bst.root, 6,10));

        /** 270. Closest Binary Search Tree Value */
        Integer[] t2 = new Integer[]{4,2,5,1,3};
        bst.root = bst.buildBst(t2);
        CloestBinaryTreeValue cloestBinaryTreeValue = new CloestBinaryTreeValue();
        System.out.println(cloestBinaryTreeValue.closestValue(bst.root, 3.714286));

    }
}
