package MiddleCode;

import DataStruct.TreeLinkNode;

/**
 * Author:CZD
 * Question:No117PopulatingNextRightPointersinEachNode2
 * Time:19-2-15 上午10:43
 */
public class No117PopulatingNextRightPointersinEachNode2 {
    /*
    *@author:CZD
    *@Description:和116的大体思路一致，区别在于不是完美二叉树，所以要判断缺少节点的情况。
    * 特别注意可能出现两个节点距离很远的情况，在解法中添加了while循环来链接很远的节点，而
    * 这样做的前提条件是父节点的链接要已经建立好，链表是从左向右扫描建立，因此需要先递归右子树。
    * 读者这里不明白的话可以先递归左子树看看错误结果画画图，更加容易理解。本写法耗时较长，但胜在
    * 容易理解，读者可自行改进写法，以获得更优的时空复杂度。
    *@DATE:上午11:46 19-2-15
    *@Param:
    *@return:
    **/

    public void connect(TreeLinkNode root) {
        //递归出口
        if(root==null||(root.left==null&&root.right==null))
            return;
        //左子节点和右子节点建立next链接
        if(root.left!=null&&root.right!=null)
            root.left.next=root.right;
        //如果有右兄弟
        if(root.next!=null)
        {
            //建立root.right和rightBro.left的关系
            TreeLinkNode rightBro=root.next;
            //寻找两个相距远的节点
            while(rightBro.left==null&&rightBro.right==null&&rightBro.next!=null)
                rightBro=rightBro.next;
            //判断左右子节点的存在情况
            if(root.right==null)
            {
                //判断兄弟左右子节点的存在情况，确定要链接的子节点
                if(rightBro.left!=null)
                    root.left.next=rightBro.left;
                else if(rightBro.right!=null)
                    root.left.next=rightBro.right;
            }
            else
            {
                //判断兄弟左右子节点的存在情况，确定要链接的子节点
                if(rightBro.left!=null)
                    root.right.next=rightBro.left;
                else if(rightBro.right!=null)
                    root.right.next=rightBro.right;
            }
        }
        connect(root.right);
        connect(root.left);
    }
}
