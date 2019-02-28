package NowCode;

import java.util.Scanner;

/**
 * Author:CZD
 * Question:TheFavourOfUsers
 * Time:19-2-26 上午10:26
 */
public class TheFavourOfUsers {

    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int fav[]=new int[n];
        for(int i=0;i<n;i++)
            fav[i]=sc.nextInt();
        int q=sc.nextInt();
        for(int i=0;i<q;i++)
        {
            int l=sc.nextInt();
            int r=sc.nextInt();
            int k=sc.nextInt();
            System.out.println(TheFavourOfUsers.SearchFav(fav,l,r,k));
            
        }

    }
    public static int SearchFav(int []fav,int l,int r,int k)
    {
        int res=0;
        for(int i=l-1;i<r;i++)
        {
            if(fav[i]==k)
                res++;

        }
        return res;
    }
}
