package MiddleCode;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:CZD
 * Question:No94BinaryTreeInorderTraversal
 * Time:19-2-1 上午10:42
 */
public class No94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList<Integer>();
        List<Integer> res=new ArrayList<Integer>();
        Stack <TreeNode>S=new Stack<TreeNode>();
        S.push(root);
        root=root.left;
        while(!S.empty())
        {
            //遍历左子树
            while(root!=null)
            {
                S.push(root);
                root=root.left;
            }
            //弹出根
            root=S.pop();
            res.add(root.val);
            //判断有无右子树
            root = root.right;
            if(root!=null)
            {
                S.push(root);
                root=root.left;
            }

        }

        return res;
    }
}
