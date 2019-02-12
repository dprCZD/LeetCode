package MiddleCode;

import DataStruct.TreeNode;

/**
 * Author:CZD
 * Question:No98ValidateBinarySearchTree
 * Time:19-2-11 上午10:14
 */
public class No98ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {
        return isBST(root,(long)Integer.MIN_VALUE-1,(long)Integer.MAX_VALUE+1);
    }
    /**
    *@author:CZD
    *@Description:别问我为什么用long...测试用例全都是MAXVALUE MINVALUE。
     * 思路就是设定区间，二叉搜索树必须小于这个区间。还有一种方法是中序遍历然后看是否是升序，
     * 但是那个时间复杂度比较高。
    *@DATE:上午11:20 19-2-11
    *@Param:[root, min, max]
    *@return: boolean
    **/
    boolean isBST(TreeNode root,long min,long max)
    {
        boolean res=false;
        if(root==null)
            return true;
        if(root.val>=max||root.val<=min)
            return false;
        res= isBST(root.left,min,root.val);
        if(res)
            res= isBST(root.right,root.val,max);
        return res;

    }
}
