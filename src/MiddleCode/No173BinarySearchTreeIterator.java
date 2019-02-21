package MiddleCode;

import DataStruct.TreeNode;

import java.util.Stack;

/**
 * Author:CZD
 * Question:No173BinarySearchTreeIterator
 * Time:19-2-21 上午10:21
 */
public class No173BinarySearchTreeIterator {

    class BSTIterator {
        Stack <TreeNode>S=new Stack();
        TreeNode root;
        /*
        *@author:CZD
        *@Description:这题的题解就写在这吧。
        * 思路：基本就是中序遍历的迭代思路。一路将左支压栈，栈顶
        * 就是最小的元素。当next()取出栈顶元素以后判断该元素有无右子树，
        * 有的话转移到右子树，继续将该子树的左支压栈。
        *@DATE:上午10:29 19-2-21
        *@Param:[root]
        *@return:
        **/
        public BSTIterator(TreeNode root) {
            this.root=root;
            while(root!=null)
            {
                S.push(root);
                root=root.left;
            }

        }

        /** @return the next smallest number */
        public int next() {
            TreeNode p=S.pop();
            int res=p.val;
            if(p.right!=null)
            {
                p=p.right;
                while(p!=null)
                {
                    S.push(p);
                    p=p.left;
                }
            }
            return res;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !S.empty();

        }
    }

}
