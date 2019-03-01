package EasyCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:CZD
 * Question:No169MajorityElement
 * Time:19-3-1 上午10:15
 */
public class No169MajorityElement {
    /*
    *@author:CZD
    *@Description:正常使用hashmap来做的方法,将数组元素都存到map里,再到value中
    * 找超过n/2的元素,对应的KEY就是众数.
    *@DATE:上午10:32 19-3-1
    *@Param:[nums]
    *@return: int
    **/
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> S=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(S.containsKey(nums[i]))
            {
                int temp=S.get(nums[i])+1;
                S.replace(nums[i],temp);
            }
            else
                S.put(nums[i],0);
        }
        for(Integer i:S.keySet())
        {
            if(S.get(i)>nums.length/2)
                return S.get(i);
        }
        return -1;

    }
    /*
    *@author:CZD
    *@Description:这个解法可能才是出题者的意图:摩尔投票法.
    * 摩尔投票法:这种投票法先将第一个数字假设为众数，然后把
    * 计数器设为1，比较下一个数和此数是否相等，若相等则计数
    * 器加一，反之减一。然后看此时计数器的值，若为零，则将
    * 下一个值设为候选众数。
    * 摩尔投票法的验证请自行Google.
    *@DATE:上午10:38 19-3-1
    *@Param:[nums]
    *@return: int
    **/
    public int majorityElement2(int[] nums) {
        int count=0;
        int res=0;
        for(int num:nums)
        {
            if(count==0)res=num;
            if(res==num)count++;
            else count--;
        }
        return res;

    }
}
