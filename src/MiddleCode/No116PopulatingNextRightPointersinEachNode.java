package MiddleCode;

import DataStruct.TreeLinkNode;

/**
 * Author:CZD
 * Question:No116PopulatingNextRightPointersinEachNode
 * Time:19-2-14 上午10:35
 */
public class No116PopulatingNextRightPointersinEachNode {
    /*
    *@author:CZD
    *@Description:这道题LeetCode上居然没有测试用例！！！自己也懒得构造树了，
    * 硬着头皮0测试提交居然过了0MS...不过这题还是很简单的，根据题设不能用BFS，
    * BFS的空间复杂度有logN了，不符合要求。
    * 思路：其实草稿纸上画一下图很容易得出结果，先将当前节点的左子节点和右子节点
    * 连接起来，就会发现！当前节点root的右子节点(root.right)和它的右兄弟的左
    * 子节点(rightBro.left)通过上述步骤还没有建立联系，因此建立起来它们的next
    * 关系就大功告成！
    *@DATE:上午10:44 19-2-14
    *@Param:[root]
    *@return: void
    **/
    public void connect(TreeLinkNode root) {
        //递归出口
        if(root==null||root.left==null||root.right==null)
            return;
        //左子节点和右子节点建立next链接
        root.left.next=root.right;
        //如果有右兄弟
        if(root.next!=null)
        {
            //建立root.right和rightBro.left的关系
            TreeLinkNode rightBro=root.next;
            root.right.next=rightBro.left;
        }
        connect(root.left);
        connect(root.right);


    }
}
