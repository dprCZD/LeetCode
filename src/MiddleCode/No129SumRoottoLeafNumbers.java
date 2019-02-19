package MiddleCode;

import DataStruct.TreeNode;

/**
 * Author:CZD
 * Question:No129SumRoottoLeafNumbers
 * Time:19-2-19 上午10:32
 */
public class No129SumRoottoLeafNumbers {
    int res=0;
    public int sumNumbers(TreeNode root) {

        addLeafs(root,0);
        return res;
    }
    /*
    *@author:CZD
    *@Description:I have nothing to say because it is so easy....
    * 就是简单的递归求解问题，当然还有更好的解法读者可以自己去探索。
    *@DATE:上午10:40 19-2-19
    *@Param:[root, all]
    *@return: void
    **/
    void addLeafs(TreeNode root,int all)
    {
        if(root==null)
            return;
        all=all*10+root.val;
        if(root.left==null&&root.right==null)
        {
            res+=all;
            return;
        }
        addLeafs(root.left,all);
        addLeafs(root.right,all);
    }
}
