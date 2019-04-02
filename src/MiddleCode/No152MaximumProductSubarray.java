package MiddleCode;

/**
 * Author:CZD
 * Question:No152MaximumProductSubarray
 * Time:19-3-28 下午6:31
 */
public class No152MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int imax=1;
        int imin=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            max=Math.max(imax,max);
        }
        return max;
    }
    public static void main(String []args)
    {
        int test[]={-1,-2,-9,-6};
        maxProduct(test);
    }
}
