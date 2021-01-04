package BSTBuilder;

public class MainClass
{
    public static void main(String[] args)
    {
        BuildBST buildBST = new BuildBST();
        Integer[] tree  = new Integer[]{99,35,19,0,11,40,5};
        buildBST.root = buildBST.buildBst(tree);

        TraversalDFS dfs = new TraversalDFS();
        dfs.inorder(buildBST.root);
    }
}
