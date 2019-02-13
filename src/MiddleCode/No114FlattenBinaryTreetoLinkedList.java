package MiddleCode;

import DataStruct.TreeNode;

import java.util.Stack;

/**
 * Author:CZD
 * Question:No114FlattenBinaryTreetoLinkedList
 * Time:19-2-13 上午10:11
 */
public class No114FlattenBinaryTreetoLinkedList {
    /*
    *@author:CZD
    *@Description:思路还是递归构造，从最底层开始将右子树换成左子树，
    * 删除原来的左子树指针，并且将原来的右子树连接到原左子树末尾的右指针。
    *@DATE:上午10:50 19-2-13
    *@Param:[root]
    *@return: void
    **/
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.left);
        flatten((root.right));
        if(root.left!=null)
        {
            //记录原来的右子树
            TreeNode temp=root.right;
            //右子树换成左子树
            root.right=root.left;
            //寻找原左子树的右指针末尾
            TreeNode p=root.right;
            while(p.right!=null)
                p=p.right;
            p.right=temp;
            //左子树置空
            root.left=null;
        }

    }

}
