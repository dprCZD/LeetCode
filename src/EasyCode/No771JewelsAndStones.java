package EasyCode;

public class No771JewelsAndStones {
   /*
   *@author:CZD
   *@Description:
   *@DATE:上午11:00 19-1-28
   *@Param:[J, S]
   *@return: int       
   **/
    public int numJewelsInStones(String J, String S) {
        char Jwls[]=J.toCharArray();
        char stones[]=S.toCharArray();
        int result=0;
        boolean AsciiMap[] =new boolean[128];
        for(int i=0;i<Jwls.length;i++)
            AsciiMap[Jwls[i]]=true;
        for(int i=0;i<stones.length;i++)
            if(AsciiMap[stones[i]])
                result++;
        return result;
    }
}
