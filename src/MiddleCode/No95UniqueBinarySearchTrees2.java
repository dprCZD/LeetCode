package MiddleCode;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:CZD
 * Question:No95UniqueBinarySearchTrees2
 * Time:19-2-20 下午3:51
 */
public class No95UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {


        return createTrees(1,n);
    }
    /*
    *@author:CZD
    *@Description:很惭愧是看着大神的解法写出来的，本人还是比较菜。
    * 思路：循环+递归遍历所有情况，有点类似于快排，要注意的是res.add(null)
    * 这一句话，非常关键，树的左右支很有可能为空。一开始没有想通这句话
    * 的含义导致疯狂失败。
    *@DATE:下午4:16 19-2-20
    *@Param:[start, end]
    *@return: java.util.List<DataStruct.TreeNode>
    **/
    List<TreeNode> createTrees(int start,int end)
    {
        List<TreeNode> res=new ArrayList<>();
        if(start>end)
        {
            //至关重要
            res.add(null);
            return res;
        }

        for(int i=start;i<end;i++)
        {
            List<TreeNode> LSubTree=createTrees(start,i);
            List<TreeNode> RSubTree=createTrees(i+1,end);
            for(TreeNode Left:LSubTree)
                for(TreeNode Right:RSubTree)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=Left;
                    root.right=Right;
                    res.add(root);
                }
        }
        return res;
    }
}
