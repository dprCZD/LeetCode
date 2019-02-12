package MiddleCode;

import DataStruct.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Author:CZD
 * Question:No105ConstructBinaryTreefromPreorderandInorderTraversal
 * Time:19-2-11 上午11:30
 */
public class No105ConstructBinaryTreefromPreorderandInorderTraversal {
    int i=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        return createTree(preorder,inorder,0,preorder.length);
    }
    /*
    *@author:CZD
    *@Description:和No106基本一样，异曲同工，具体思路及注释参见No106.
    *@DATE:下午1:05 19-2-11
    *@Param:[preorder, inorder, start, end]
    *@return: DataStruct.TreeNode
    **/
    TreeNode createTree(int[] preorder, int[] inorder,int start,int end)
    {
        TreeNode root=new TreeNode(preorder[i++]);
        int rIndex=getrIndex(root.val,inorder);
        if(i<preorder.length) {
            int IsLeft=isLeft(inorder, root.val, preorder[i], start, end);
            if(IsLeft==0)
                return root;
            if ( IsLeft== 1)
                root.left = createTree(preorder, inorder, start, rIndex);
            if(i<preorder.length&&isLeft(inorder, root.val, preorder[i], start, end)==-1)
                root.right = createTree(preorder, inorder, rIndex + 1, end);
        }

        return root;
    }
    int isLeft(int[] inorder,int rootVal,int subVal,int start,int end)
    {
        int sIndex=-1;
        int rIndex=-1;
        for(int i=start;i<end;i++)
        {
            if(inorder[i]==rootVal)
                rIndex=i;
            if(inorder[i]==subVal)
                sIndex=i;
        }
        if(sIndex==-1)
            return 0;
        if(rIndex>sIndex)
            return 1;
        else
            return -1;
    }
    int getrIndex( int val,int []inorder)
    {
        for(int i=0;i<inorder.length;i++)
            if(val==inorder[i])
                return i;
        return -1;
    }
    public static void main(String []args)
    {
        int p[]={3,2,1,4};
        int i[]={1,2,3,4};
        No105ConstructBinaryTreefromPreorderandInorderTraversal t=new
                No105ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode.PreOrder(t.buildTree(p,i));;

    }
}
