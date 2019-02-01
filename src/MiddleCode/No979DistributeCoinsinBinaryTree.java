package MiddleCode;

import DataStruct.TreeNode;

/**
 * Author:CZD
 * Question:DistributeCoinsinBinaryTree
 * Time:19-2-1 上午10:19
 */
public class No979DistributeCoinsinBinaryTree {
    int ans=0;
    public int distributeCoins(TreeNode root) {
            dfs(root);
            return ans;
    }
    /*
    *@author:CZD
    *@Description:假设当前节点的值为1，则过载量为0，该节点无需移动，如果值为0，
    * 过载量为-1，需要从父节点移动一个硬币，如果为N，则过载量为N-1，需要从该节点移除N-1个硬币，
    * 而当前节点的总过载量为：N-1+左子树的过载量+右子树的过载量。
    * 推得从当前节点移动到当前节点所需的步数为：左子树的过载量+右子树的过载量。
    *@DATE:上午10:25 19-2-1
    *@Param:[root]
    *@return: int
    **/
    int dfs(TreeNode root)
    {
        if(root ==null)
            return 0;
        int left =dfs(root.left);
        int right=dfs(root.right);
        //计算总步数
        ans=ans+Math.abs(left)+Math.abs(right);
        //返回当前节点的总过载量
        return root.val-1+left+right;
    }
}
