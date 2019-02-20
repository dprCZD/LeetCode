package DifficultCode;

import DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Author:CZD
 * Question:No145PostOrder
 * Time:19-2-20 下午3:23
 */
public class No145PostOrder {
    /*
    *@author:CZD
    *@Description:递归太EASY了就不写了，这里主要的想法是：
    * 后根遍历是左->右->根，而反过来就是根右左，也就是优先右侧
    * 的先根遍历然后reverse即可。
    *@DATE:下午3:39 19-2-20
    *@Param:[root]
    *@return: java.util.List<java.lang.Integer>
    **/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> S=new Stack<>();;
        TreeNode p=root;
        while(p!=null||!S.empty())
        {
            while(p!=null)
            {
                res.add(p.val);
                S.push(p);
                p=p.right;
            }
            p=S.pop();
            p=p.left;

        }
        Collections.reverse(res);
        return res;
    }


}
