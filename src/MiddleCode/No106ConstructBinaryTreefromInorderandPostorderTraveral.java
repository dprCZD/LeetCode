package MiddleCode;

import DataStruct.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Author:CZD
 * Question:No106ConstructBinaryTreefromInorderandPostorderTraveral
 * Time:19-2-12 上午10:11
 * some words:看了leetcode1ms的代码，写的很简便很灵活，
 * 但是思维量蛮大的，自己思考可能写不出。这里给出了一种通俗
 * 易懂的解法，可以在搞懂本解法的情况下研究一下leetcode上
 * 大神的写法。
 */
public class No106ConstructBinaryTreefromInorderandPostorderTraveral {
    int i=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i=postorder.length-1;
        return createTree(inorder,postorder,0,postorder.length);
    }
    /*
    *@author:CZD
    *@Description:在postorder中从后向前构建二叉树，在每一个节点到中序遍历中进行划分，
    * （比如遍历构造整棵树的根节点的右子树的时候在中序遍历中划分则为根节点的index的右侧）
    * 判断是否是根节点的子树。具体操作为判断当前节点（postorder[i]）是否在划分内，（如果在）
    * 再判断是当前根节点的左侧or右侧。
    *@DATE:上午10:39 19-2-12
    *@Param:[inorder, postorder, start, end]
    *@return: DataStruct.TreeNode
    **/
    TreeNode createTree(int[] inorder, int[] postorder,int start,int end)
    {

        TreeNode root=new TreeNode(postorder[i--]);
        if(i>=0)
        {
            int rIndex=getRindex(inorder,root.val);
            int test=isRight(inorder,root.val,postorder[i],start,end);
            //有子树
            if(test!=0)
            {
                //有右子树
                if(test==1)
                    root.right=createTree(inorder,postorder,rIndex+1,end);
                //有左子树，由于递归时i会变化，必须重新用isRight判断是否有左子树
                if(i>=0&&isRight(inorder,root.val,postorder[i],start,end)==-1)
                    root.left=createTree(inorder,postorder,start,rIndex);
            }
        }
        return root;
    }
    /*
    *@author:CZD
    *@Description:在中序遍历中判断相应划分范围内是否有左右子树，有右子树返回-1，有左子树返回1，否则返回0
    *@DATE:上午10:33 19-2-12
    *@Param:[inorder, rootVal, subVal, start, end]
    *@return: int
    **/
    int isRight(int[] inorder,int rootVal,int subVal,int start,int end)
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
        if(sIndex==-1||rIndex==-1)
            return 0;
        if(rIndex<sIndex)
            return 1;
        else
            return -1;
    }
    /*
    *@author:CZD
    *@Description:获得根节点在中序遍历中的index
    *@DATE:上午10:35 19-2-12
    *@Param:[inorder, rootVal]
    *@return: int
    **/
    int getRindex(int[] inorder,int rootVal)
    {
        for(int i=0;i<inorder.length;i++)
            if(inorder[i]==rootVal)
                return i;
        return -1;
    }
    public static void main(String []args)
    {
        int p[]={9,3,15,20,7};
        int i[]={9,15,7,20,3};
        No106ConstructBinaryTreefromInorderandPostorderTraveral t=new
                No106ConstructBinaryTreefromInorderandPostorderTraveral();
        TreeNode.PreOrder(t.buildTree(p,i));;

    }
}
