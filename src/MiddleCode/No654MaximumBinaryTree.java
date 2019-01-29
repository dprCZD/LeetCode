package MiddleCode;
import DataStruct.TreeNode;


/**
 * Author:CZD
 * Question:No654MaximumBinaryTree
 * Time:19-1-29 下午5:16
 */
public class No654MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return CreateMaxTree(nums,0,nums.length);
    }
    //划分数组，递归构造
    TreeNode CreateMaxTree(int[] nums,int left,int right)
    {
        if(left>=right)
            return null;
        int index=FindMaxNum(nums,left,right);
        TreeNode root =new TreeNode(nums[index]);
        root.left=CreateMaxTree(nums,left,index);
        root.right=CreateMaxTree(nums,index+1,right);
        return root;

    }
    //找出最大值
    int FindMaxNum(int[]nums,int left,int right)
    {
        int index=left;
        int max=nums[left];

        for(int i=left;i<right;i++)
        {
            if(max<nums[i])
            {
                max=nums[i];
                index=i;
            }
        }
        return index;
    }
}
