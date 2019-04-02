package EasyCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:CZD
 * Question:No217ContainsDuolicate
 * Time:19-4-2 下午2:46
 */
public class No217ContainsDuolicate {
    /*
    *@author:CZD
    *@Description:
    *@DATE:下午2:46 19-4-2
    *@Param:
    *@return:
    **/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(res.contains(nums[i]))
                return true;
            res.add(nums[i]);
        }
        return false;
    }
}
