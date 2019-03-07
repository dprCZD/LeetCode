package EasyCode;

/**
 * Author:CZD
 * Question:No344ReverseString
 * Time:19-3-7 下午3:05
 */
public class No344ReverseString {
    /*
    *@author:CZD
    *@Description:比较简单,不多说看代码.
    *@DATE:下午3:14 19-3-7
    *@Param:[s]
    *@return: void
    **/
    public void reverseString(char[] s) {
        char temp=s[0];
        for(int i=0;i<s.length/2;i++)
        {
            temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }


    }
}
