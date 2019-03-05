package EasyCode;

/**
 * Author:CZD
 * Question:No125ValidPalindrome
 * Time:19-3-5 上午9:07
 */
public class No125ValidPalindrome {
    /*
    *@author:CZD
    *@Description:比较简单的字符串题.比较考验
    * 对语言字符串的操作和理解.
    * 思路:先规范化数据,再循环判断就OK.
    *@DATE:上午9:25 19-3-5
    *@Param:[s]
    *@return: boolean
    **/
    public boolean isPalindrome(String s) {

        StringBuilder format=new StringBuilder();
        //规范化数据
        for(int k=0;k<s.length();k++)
        {
            char temp=s.charAt(k);
            if(temp>47&&temp<58||(temp>64&&temp<91))
                format.append(temp);
            else if(temp>96&&temp<123)
                format.append((char)(temp-32));
            else
                continue;

        }
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
        No125ValidPalindrome test=new No125ValidPalindrome();
        test.isPalindrome("A man, a plan, a canal: Panama");
        String te11st="aaa";
        System.out.println(te11st.substring(te11st.length()));
    }
}
