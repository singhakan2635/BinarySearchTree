package LeetCodeEasy;

import BSTBuilder.BuildBST;
import BSTBuilder.TraversalDFS;
import BSTBuilder.TreeNode;
import LeetCodeMedium.ConvertBSTtoGreaterTree;

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

        /** 653. Two Sum IV - Input is a BST */
        Integer[] t3 = new Integer[]{2,1,3};
        bst.root = bst.buildBst(t3);
        TwoSuminBST twoSum = new TwoSuminBST();
        System.out.println(twoSum.findTarget(bst.root, 4));

        /** 538. Convert BST to Greater Tree */
        Integer[] t4 = new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        bst.root = bst.buildBst(t4);
        ConvertBSTtoGreaterTree convert = new ConvertBSTtoGreaterTree();
        TreeNode root = convert.convertBST(bst.root);
        dfs.inorder(root);

    }
}
