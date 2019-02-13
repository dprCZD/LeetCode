package MiddleCode;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:CZD
 * Question:No113PathSum2
 * Time:19-2-12 上午11:08
 */
public class No113PathSum2 {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return result;

    }
    /*
    *@author:CZD
    *@Description:这道题大体思路和简单题的No112PathSum一致，算法本身毫无难度。
    * 难点在于对于递归时值传递及引用传递的理解，考察了对于List的应用。把List当做
    * Stack,运用堆栈思维求解会较快地解决本题。注意本题会有重复的树节点，要小心应付。
    *@DATE:上午11:33 19-2-12
    *@Param:[root, sum, res, list]
    *@return: void
    **/
    public void isPathSum(TreeNode root, int sum,int res,List<Integer>list)
    {
        if(root==null)
        return;
        if(root.left==null&&root.right==null)
        {
            if(res+root.val==sum) {
                list.add(root.val);
                List data = new ArrayList<>();
                data.addAll(list);
                list.remove(list.size()-1);
                result.add(data);
            }
            return;
        }
        list.add(root.val);
        isPathSum(root.left,sum,res+root.val,list);
        isPathSum(root.right,sum,res+root.val,list);
        list.remove(list.size()-1);
    }
}
