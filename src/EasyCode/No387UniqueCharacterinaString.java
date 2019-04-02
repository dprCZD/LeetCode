package EasyCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:CZD
 * Question:No387UniqueCharacterinaString
 * Time:19-3-25 上午11:02
 */
public class No387UniqueCharacterinaString {
    /*
    *@author:CZD
    *@Description:hash映射一下,把重复的置为MAX
    *@DATE:上午11:15 19-3-25
    *@Param:[s]
    *@return: int
    **/
    public int firstUniqChar(String s) {
        Map<Character,Integer> container=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char temp=s.charAt(i);
            if(container.containsKey(temp))
                container.replace(temp,Integer.MAX_VALUE);
            else container.put(temp,i);
        }
        int res=Integer.MAX_VALUE;
        for(Integer data:container.values())
            res=Math.min(res,data);


        return res==Integer.MAX_VALUE?-1:res;
    }
}
