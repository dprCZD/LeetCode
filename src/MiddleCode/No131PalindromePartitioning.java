package MiddleCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:CZD
 * Question:No131PalindromePartitioning
 * Time:19-3-5 上午9:33
 */
public class No131PalindromePartitioning {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        subPartition(s,"");
        return res;
    }
    /*
    *@author:CZD
    *@Description:这个问题可以拆分成两个子问题,第一个问题是
    * 找出字符串的所有划分方式,第二个问题是判断每一种划分中的子串
    * 是否全为回文串.典型的回溯法思想.但是当递归和字符串相爱,调试
    * 就成了代码的噩梦.思路五分钟,改错两小时.
    *@DATE:下午3:34 19-3-5
    *@Param:[s, sRes]
    *@return: void
    **/
    public void  subPartition(String s,String sRes)
    {
        String rec=sRes;
        if(s.equals(""))
        {
            String temp[]=sRes.split(":");
            List<String> tRes=new ArrayList<>();
            for(int i=0;i<temp.length;i++)
                tRes.add(temp[i]);
            res.add(tRes);
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String t1=s.substring(0,i+1);
            if(isPalindrome(t1))
            {
                t1=t1+":";
                sRes=sRes+t1;
                subPartition(s.substring(i+1),sRes);
            }
            sRes=rec;
        }
    }
    public boolean isPalindrome(String format) {
        //判断
        int len=format.length();
        int i=0;
        int j=len-1;
        while(i<len/2)
        {
            if(format.charAt(i)!=format.charAt(j))
                return false;
            i++;
            j--;
        }


        return true;
    }
    public static void main(String []args)
    {
        No131PalindromePartitioning t=new No131PalindromePartitioning();
        t.partition("cdd");
    }

}
