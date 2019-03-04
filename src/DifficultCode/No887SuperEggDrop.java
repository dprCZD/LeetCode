package DifficultCode;

import java.util.Arrays;

/**
 * Author:CZD
 * Question:No887SuperEggDrop
 * Time:19-3-4 下午3:19
 */
public class No887SuperEggDrop {
    /*
    *@author:CZD
    *@Description:这道题真的是杀机重重啊...
    * 这个方法是动态规划,思想是:
    * 我们用dp[n][k]表示k个鸡蛋测n层的扔的次数。如果i层的时候鸡蛋碎了，
    * 剩下来的k-1个鸡蛋用来测i-1层，也就是dp[n][k]=dp[i-1][k-1]+1；
    * 如果i层的时候鸡蛋没有碎，那么剩下来的k个鸡蛋用来测n-i个楼层。
    * 所以，在第i层扔，会用 max(dp[i-1][k-1], dp[n-i][k]) + 1，即
    * dp[n][k]=min(max(dp[i−1][k−1],dp[n−i][k])+1)(1<=i<=n)
    *
    * PS:超出时间界限,虽然已经比较容易想到了,但是还是不符合"困难"的难度啊.
    *@DATE:下午5:45 19-3-4
    *@Param:[K, N]
    *@return: int
    **/
    public static int superEggDrop(int K, int N) {
        int dp[][]=new int[K+1][N+1];
        for(int i=0;i<N+1;i++)
            dp[0][i]=0;
        for(int i=0;i<K+1;i++)
            dp[i][0]=0;
        for(int i=0;i<N+1;i++)
            dp[1][i]=i;
        //遍历每种鸡蛋数量的情况
        for (int i=2;i<K+1;i++)
            //遍历每鸡蛋数量情况下每种高度的情况
            for(int j=1;j<N+1;j++)
            {
                int min=Integer.MAX_VALUE;
                //给定高度和数量确定方法数.
                for(int x=1;x<j+1;x++)
                    min=Math.min(min,1+Math.max(dp[i][j-x],dp[i-1][x-1]));
                dp[i][j]=min;
            }


        return dp[K][N];
    }
    /*
    *@author:CZD
    *@Description:更加优秀一点的解法:
    * 我们可以改变一下求解的思路，求k个鸡蛋在m步内可以测出多少层：
    * 假设: dp[k][m] 表示k个鸡蛋在m步内最多能测出的层数。
    * 那么，问题可以转化为当 k <= K 时，找一个最小的m，使得dp[k][m]<= N。
    * 由此,我们可以考量:
    * 如果鸡蛋没碎，我们接下来会在更高的楼层扔，最多能确定 X + dp[k][m-1] 层的结果；
    * 如果鸡蛋碎了，我们接下来会在更低的楼层扔，最多能确定 Y + dp[k-1][m-1]层的结果 (假设在第X层上还有Y层)。
    * 因此，这次扔鸡蛋，我们最多能测出 dp[k-1][m-1](摔碎时能确定的层数) + dp[k][m-1] (没摔碎时能确定的层数) + 1 (本层) 层的结果。
    * 另外，我们知道一个鸡蛋一次只能测一层，没有鸡蛋一层都不能测出来。
    * 得出递推关系式:
    * dp[k][m] = dp[k-1][m-1] + dp[k][m-1] + 1 (k > 0, m>0)
    *@DATE:下午6:14 19-3-4
    *@Param:[K, N]
    *@return: int
    **/
    public static int superEggDrop2(int K, int N) {
        int dp[][]=new int[K+1][N+1];
        //没有鸡蛋一层都不能测出来。
        for(int i=0;i<N+1;i++)
            dp[0][i]=0;
        //0层不需要测
        for(int i=0;i<K+1;i++)
            dp[i][0]=0;
        //一个鸡蛋一次只能测一层
        for(int i=0;i<N+1;i++)
            dp[1][i]=i;
        //循环顺序非常重要,外圈循环代表的是在j次步骤内i个鸡蛋最多能测出多少层.
        for(int j=1;j<N+1;j++)
            for(int i=1;i<K+1;i++)
            {
                dp[i][j]=1+dp[i-1][j-1]+dp[i][j-1];
                if(dp[i][j]>=N)
                    return j;
            }
        return N;
    }
    public static void main (String []args)
    {
      System.out.println(superEggDrop2(3,14));
    }
}
