package MiddleCode;

/**
 * Author:CZD
 * Question:No96UniqueBinarySearchTrees
 * Time:19-2-3 上午10:41
 */
public class No96UniqueBinarySearchTrees {

    /*
    *@author:CZD
    *@Description:动态规划思想：
    * 1~n有n个不同根的情况
    * 每一个根的所有情况等于：左子树的所有情况×右子树的所有情况
    *@DATE:上午10:44 19-2-3
    *@Param:[n]
    *@return: int
    **/
    public int numTrees(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int nums[]=new int[n+1];
        nums[0]=1;
        nums[1]=1;
        for(int i=2;i<=n;i++)
            for(int j=0;j<i;j++)
                nums[i]=nums[i]+nums[j]*nums[i-1-j];
        return nums[n];
    }
}
