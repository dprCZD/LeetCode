package DataStruct;

/**
 * Author:CZD
 * Question:TreeNode
 * Time:19-1-29 下午5:18
 */
 public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }


    public static void PreOrder(TreeNode root)
    {
        if(root==null)
            return;
        System.out.println(root.val);
        PreOrder(root.left);
        PreOrder(root.right);
    }
}