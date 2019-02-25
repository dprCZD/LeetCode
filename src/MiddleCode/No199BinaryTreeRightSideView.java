package MiddleCode;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:CZD
 * Question:No199BinaryTreeRightSideView
 * Time:19-2-25 下午2:34
 */
public class No199BinaryTreeRightSideView {

    Map<Integer,TreeNode> S=new HashMap<>();
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        getRightSide(0,root);
        return res;
    }
    /*
    *@author:CZD
    *@Description:一种正常的解法是用层次遍历..我也不知道哪里脑子轴了，
    * 非要用深度优先遍历..可能是爱得深沉。
    * 思路：创建一个map存储每层的最右测节点，再次深搜到这一层时因为map里
    * 有数据便不会刷新，如果深搜到新一层则会添加这一层的最右侧节点。
    *@DATE:下午2:44 19-2-25
    *@Param:[h, root]
    *@return: void
    **/
    void getRightSide(int h,TreeNode root)
    {
        if(root==null)
            return;
        if(!S.containsKey(h))
        {
            S.put(h,root);
            res.add(root.val);
        }
        h++;
        getRightSide(h,root.right);
        getRightSide(h,root.left);
    }
}
