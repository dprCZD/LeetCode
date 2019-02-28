package NowCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:CZD
 * Question:DiffColorOfBracelet
 * Time:19-2-26 上午10:40
 */
public class DiffColorOfBracelet {

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int res=0;
        List<List<Integer>> color = new ArrayList<>();
        int cnum[] = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            cnum[i] = sc.nextInt();
            for (int j = 0; j < cnum[i]; j++)
                temp.add(sc.nextInt());
            color.add(temp);
        }
        for(int i=1;i<c+1;i++)
            if(!DiffColorOfBracelet.isTrue(i,m,color))
                res++;
        System.out.println(res);
    }
    static boolean isTrue(int tCor,int m,List<List<Integer>> color)
    {

        int n=color.size();
        if(m>=n)
        {
            int test=0;
            for(int i=0;i<n;i++)
                if(color.get(i).contains(tCor))
                {
                    test++;
                    if(test>1)
                        return false;
                }
        }
        else
        {

            for(int i=0;i<n;i++)
            {
                int left=i;
                int right=m+i;
                int test=0;
                for(int j=left;j<right;j++)
                    if(color.get(j%n).contains(tCor))
                    {
                        test++;
                        if(test>1)
                            return false;
                    }
                test=0;
            }
        }


        return true;
    }
}
