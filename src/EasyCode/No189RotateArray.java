package EasyCode;

/**
 * Author:CZD
 * Question:No189RotateArray
 * Time:19-3-29 上午10:38
 */
public class No189RotateArray {

    public void rotate(int[] nums, int k) {
        int data=0;
        for(int i=0;i<k;i++)
        {
            data=nums[0];
            nums[0]=nums[nums.length-1];
            for(int j=nums.length-1;j>1;j++)
                nums[j]=nums[j-1];
            nums[1]=data;
        }
    }
}
