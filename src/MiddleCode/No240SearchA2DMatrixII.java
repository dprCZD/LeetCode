package MiddleCode;

/**
 * Author:CZD
 * Question:No240SearchA2DMatrixII
 * Time:19-3-1 上午10:44
 */
public class No240SearchA2DMatrixII {
    /*
    *@author:CZD
    *@Description:考验观察力.右上角的元素左侧都比它小,下侧都比它大.
    * 判断一下走左/下就完事儿了...
    *@DATE:上午11:03 19-3-1
    *@Param:[matrix, target]
    *@return: boolean
    **/
    public boolean searchMatrix(int[][] matrix, int target) {

        int i=0;
        int j=matrix[0].length-1;
        int start;
        while(j>=0&&i<matrix.length)
        {
            start=matrix[i][j];
            if(target>start)
                i++;
            else if(target<start)
                j--;
            else if(target==start)
                return true;
        }
        return false;

    }
}
