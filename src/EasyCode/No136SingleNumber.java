package EasyCode;

/**
 * Author:CZD
 * Question:No136SingleNumber
 * Time:19-2-28 上午11:08
 */
public class No136SingleNumber {

    /*
    *@author:CZD
    *@Description:根据题目要求的线性时间复杂度和0额外空间,
    * 解决思路:根据异或相等的数为0,所以只要将整个数组所有数据全部
    * 异或到nums[0]中,最后的结果就是答案.
    * 题外话:这个真的想不到啊.思来想去想破脑袋没想出又不要额外空间又
    * 线性的方法,排序复杂度nlogn,用hashmap/set空间复杂度又为n..
    *@DATE:上午11:09 19-2-28
    *@Param:[nums]
    *@return: int
    **/
    public int singleNumber(int[] nums) {
        for(int i=1;i<nums.length;i++)
        {
            nums[0]=nums[0]^nums[i];
        }
        return nums[0];
    }
}
