package EasyCode;

import DataStruct.TreeNode;

/**
 * Author:CZD
 * Question:No112PathSum
 * Time:19-2-12 上午10:53
 */
public class No112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return isPathSum(root,sum,-1);
    }

    /*
    *@author:CZD
    *@Description:简单深搜，加到底以后比较路径和是不是sum。
    *@DATE:上午11:04 19-2-12
    *@Param:[root, sum, res]
    *@return: boolean
    **/
    boolean isPathSum(TreeNode root, int sum,int res)
    {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
        {
            res=res+root.val;
            return res==sum;
        }
        return isPathSum(root.left,sum,res+root.val)||isPathSum(root.right,sum,res+root.val);
    }
}
