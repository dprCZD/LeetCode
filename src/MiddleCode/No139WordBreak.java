package MiddleCode;

import java.util.List;

/**
 * Author:CZD
 * Question:No139WordBreak
 * Time:19-3-6 上午9:55
 */
public class No139WordBreak {
    /*
    *@author:CZD
    *@Description:这个题目还蛮难的.万能的百度给我思路.
    * 思路:动态规划.
    * 设dp[i]代表s.substring(0, i)能否被字典表达，
    * 此刻我们知道dp[0]~dp[i-1]的结果。而dp[i]的结
    * 果由两部分组成，一部分是dp[j]（j < i)，已知；
    * 另一部分是j到i之间的字符串是不是在字典里。当这
    * 两个部分都为真的时候，dp[i]即为真。而一旦dp[i]
    * 为真，就不用继续迭代了。
    *@DATE:下午2:46 19-3-6
    *@Param:[s, wordDict]
    *@return: boolean
    **/
    public boolean wordBreak(String s, List<String> wordDict) {
       boolean dp[]=new boolean[s.length()+1];
       dp[0]=true;
       for(int i=0;i<s.length()+1;i++)
       {
           for(int j=0;j<i;j++)
               if(!dp[i])
               {
                   dp[i]=dp[j]&&wordDict.contains(s.substring(j,i));
               }
       }
       return dp[s.length()];
    }

}
