package MiddleCode;

import DataStruct.TreeNode;

/**
 * Author:CZD
 * Question:No230KthSmallestElementinaBST
 * Time:19-2-28 上午10:15
 */
public class No230KthSmallestElementinaBST {

    int i=0;
    public int kthSmallest(TreeNode root, int k) {

        return getKSmallElement(root,k);
    }
    /*
    *@author:CZD
    *@Description:本题也算较为容易的一题,中序遍历记一下数,
    * 到相应序号返回就行.但是有一个问题在于传入的int递归返回时
    * 传入的int也会跟着返回,我这里用了个类变量来解决.可能还有更
    * 优雅的解决方法.看leetcode 0ms的解法也用了类变量.感觉不太美.
    *@DATE:上午10:45 19-2-28
    *@Param:[root, k]
    *@return: int
    **/
    int getKSmallElement(TreeNode root,int k)
    {
        int res=Integer.MIN_VALUE;
        if(root==null)
            return Integer.MIN_VALUE;
        if(i<k)
            res=kthSmallest(root.left,k);
        i++;

        if(i==k)
            return root.val;
        if(i<k)
            res=kthSmallest(root.right,k);
        return res;
    }
}
