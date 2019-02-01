package MiddleCode;

import DataStruct.TreeNode;

/**
 * Author:CZD
 * Question:No814BinaryTreePruning
 * Time:19-1-30 上午10:22
 */
public class No814BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        //递归出口
        if (root==null)
            return root;
        //判断当前节点是否为要删除的子树
        if(root.left==null&&root.right==null&&root.val==0)
            root.val=Integer.MIN_VALUE;
        pruneTree(root.left);
        pruneTree(root.right);
        //判断左右子树是否要被删除
        if(root.left!=null&&root.left.val==Integer.MIN_VALUE)
            root.left=null;
        if(root.right!=null&&root.right.val==Integer.MIN_VALUE)
            root.right=null;
        //删除完子树以后判断当前节点是否为要删除的子树
        if(root.left==null&&root.right==null&&root.val==0)
        {
            root.val=Integer.MIN_VALUE;
        }
        //对应[0,0,0]的情况，leetcode里面的测试用例无该情况
        if(root.val==Integer.MIN_VALUE)
            return null;
        return root;
    }
}
