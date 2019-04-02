package EasyCode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:CZD
 * Question:No303RangeSumQuery
 * Time:19-3-28 上午10:23
 */
public class No303RangeSumQuery {

    public static void main(String []args)
    {
        int nums[]={-2,0,3,-5,2,-1};
        NumArray test=new NumArray(nums);
        test.sumRange(0,2);
        test.sumRange(0,2);
    }

}
/*
 *@author:CZD
 *@Description:解法比较EASY和暴力,速度还是比较慢,不过胜在简单.
 * 思路:用一个map存储累加结果.在sumRange时假如map中有数据直接返回,
 * 否则累加出结果后存入map并返回.
 *@DATE:上午10:43 19-3-28
 *@Param:
 *@return:
 **/
class NumArray {
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    int nums[];



    public  NumArray(int[] nums) {
        this.nums=nums;
    }


    public int sumRange(int i, int j) {
        Pair<Integer, Integer> p = new Pair<>(i,j);
        //判断map是否有数据
        if(!map.containsKey(p))
        {
            int sum=0;
            for(int k=i;k<=j;k++)
            {
                sum+=nums[k];
            }
            map.put(p,sum);
            return sum;
        }
        return map.get(p);
    }

}
