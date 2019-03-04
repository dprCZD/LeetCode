package EasyCode;

/**
 * Author:CZD
 * Question:No88MergeSortedArray
 * Time:19-3-4 下午2:52
 */
public class No88MergeSortedArray {
    /*
    *@author:CZD
    *@Description:归并排序的merge操作,不多说.
    *@DATE:下午3:04 19-3-4
    *@Param:[nums1, m, nums2, n]
    *@return: void
    **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res[]=new int[m+n];
        int i=0;
        int j=0;
        int t=0;
        while(i<m&&j<n)
        {
            if(nums1[i]<nums2[j])
            {
                res[t]=nums1[i];
                i++;
                t++;
            }
            else
            {
                res[t]=nums2[j];
                j++;
                t++;
            }
        }
        while(i<m)
            res[t++]=nums1[i++];
        while(j<n)
            res[t++]=nums2[j++];
        t=0;
        while(t<res.length)
            nums1[t]=res[t++];
    }
}
