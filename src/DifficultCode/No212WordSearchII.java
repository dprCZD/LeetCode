package DifficultCode;

import DataStruct.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:CZD
 * Question:No212WordSearchII
 * Time:19-3-8 下午3:48
 */
public class No212WordSearchII {

    Trie tree;
    List<String > res;
    int max=0;
    No212WordSearchII()
    {
        tree=new Trie();
        res=new ArrayList<>();
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words)
        {
            max=Math.max(max,word.length());
            tree.insert(word);
        }
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                searchWords(board,"",i,j,tree);
        return res;


    }

    private void searchWords(char[][]board, String word, int i, int j, Trie tree)
    {
        if(i>board.length-1||j>board[0].length-1||i<0||j<0||board[i][j]=='0')
            return;
        word=word+board[i][j];
        if(tree.startsWith(word))
        {

            if(tree.search(word))
            {
                if(!res.contains(word))
                    res.add(word);
            }
                if(word.length()>max)
                    return;
                char temp=board[i][j];
                board[i][j]='0';
                searchWords(board,word,i+1,j,tree);
                searchWords(board,word,i-1,j,tree);
                searchWords(board,word,i,j+1,tree);
                searchWords(board,word,i,j-1,tree);
                board[i][j]=temp;
        }
    }

    public static void main(String []agrs)
    {
        No212WordSearchII test=new No212WordSearchII();
        Scanner sc=new Scanner(System.in);
        int n=2;
        int m=2;
        char board[][]=new char[n][m];
        String words[]=new String[7];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board[i][j]=sc.next().charAt(0);
        for(int i=0;i<words.length;i++)
            words[i]=sc.next();
        test.findWords(board,words);
    }
}
