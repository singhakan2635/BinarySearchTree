package BSTBuilder;

import java.util.Arrays;
import java.util.Comparator;

public class BuildBST
{
    public TreeNode root;

    public TreeNode buildBst(Integer[] n)
    {
        TreeNode node =null;
        Arrays.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if (o1==null && o2==null)
                    return 0;
                if (o1==null)
                    return 1;
                if (o2==null)
                    return -1;
                return o1.compareTo(o2);
            }
        });
        return contructBST(n,0,n.length-1,node);
    }

    private TreeNode contructBST(Integer[] arr, int start, int end,TreeNode root)
    {

        if (start>end)
            return null;
        int mid = (start+end)/2;
        if (arr[mid]==null)
            return null;

        if (root==null)
        {
            root = new TreeNode(arr[mid]);
        }
        root.left = contructBST(arr,start,mid-1,root.left);
        root.right = contructBST(arr,mid+1,end,root.right);

        return root;
    }
}
