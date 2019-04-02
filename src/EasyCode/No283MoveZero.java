package EasyCode;

/**
 * Author:CZD
 * Question:No283MoveZero
 * Time:19-4-2 下午3:16
 */
public class No283MoveZero {

    /*
    *@author:CZD
    *@Description:天才思路:第一个0和非0的当前值交换!具体为什么可以自己验证.
    *@DATE:下午3:17 19-4-2
    *@Param:[nums]
    *@return: void
    **/
    public void moveZeroes(int[] nums) {
        int firstZero=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0&&firstZero==-1)
                firstZero=i;
            if(nums[i]!=0&&firstZero>0)
            {
                int temp=nums[i];
                nums[i]=0;
                nums[firstZero]=temp;
                firstZero++;
            }
        }

    }
}
