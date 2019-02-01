package MiddleCode;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:CZD
 * Question:No894AllPossibleFullBinaryTrees
 * Time:19-1-31 上午10:07
 */
public class No894AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        //偶数节点无法构成满二叉树
        if(N%2==0)
            return new ArrayList<>();
        List<TreeNode> res=new ArrayList<>();
        if(N==1)
            res.add(new TreeNode(0));
        else
        {
            //循环遍历左子树为i，右子树为N-i-1的情况
            for(int i=1;i<N;i+=2)
            {
                //递归求解，N为1时
                List <TreeNode>left=allPossibleFBT(i);
                List <TreeNode>right=allPossibleFBT(N-1-i);
                //排列组合所有可能
                for(TreeNode l:left)
                    for(TreeNode r:right)
                    {
                        TreeNode root=new TreeNode(0);
                        root.left=l;
                        root.right=r;
                        res.add(root);
                    }
            }
        }
        return res;
    }
}
