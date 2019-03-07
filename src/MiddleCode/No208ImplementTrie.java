package MiddleCode;


import java.util.HashMap;
import java.util.Map;
import DataStruct.TrieNode;

class Trie {
    TrieNode root;

    /**Initialize your data structure here. */
    /*
    *@author:CZD
    *@Description:非常经典的数据结构实现,本trie树用了
    * hashmap作为子节点列表,方便通过字符搜索,复杂度为O(1).
    *@DATE:下午2:53 19-3-7
    *@Param:[]
    *@return:
    **/
    public Trie() {
        this.root=new TrieNode("null");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char p;
        int i=0;
        TrieNode cur=root;
        while(i<word.length())
        {
            p=word.charAt(i);
            Map<Character,TrieNode>curSubNodes=cur.getSubNodes();
            if(curSubNodes.containsKey(p))
            {
                cur=curSubNodes.get(p);

            }
            else
            {
                cur=new TrieNode("null");
                curSubNodes.put(p,cur);

            }
            i++;

        }
        cur.setData(word);

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char p;
        int i=0;
        TrieNode cur=root;
        while(i<word.length())
        {
            p=word.charAt(i);
            Map<Character,TrieNode>curSubNodes=cur.getSubNodes();
            if(!curSubNodes.containsKey(p))
                return false;
            else
                cur=curSubNodes.get(p);
            i++;
        }
        if(cur.getData().equals(word))
            return true;
        else
            return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char p;
        int i=0;
        TrieNode cur=root;
        while(i<prefix.length())
        {
            p=prefix.charAt(i);
            Map<Character,TrieNode>curSubNodes=cur.getSubNodes();
            if(!curSubNodes.containsKey(p))
                return false;
            else
                cur=curSubNodes.get(p);
            i++;
        }
        return false;
    }
}
/**
 * Author:CZD
 * Question:No208ImplementTrie
 * Time:19-3-7 下午1:55
 */
public class No208ImplementTrie {

    public static void main(String args[])
    {
        Trie a=new Trie();
        a.insert("apple");
    }
}
