package EasyCode;

import java.util.Arrays;

/**
 * Author:CZD
 * Question:No242ValidAnagram
 * Time:19-3-22 下午1:04
 */
public class No242ValidAnagram {

    public boolean isAnagram(String s, String t)
    {
        if(s.length()!=t.length())return false;
        char[] as=s.toCharArray();
        char[] ts=t.toCharArray();
        Arrays.sort(as);
         String test="a";
         test=test+100;
        Arrays.sort(ts);
        return Arrays.equals(as,ts);
    }
}
