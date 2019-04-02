package MiddleCode;


import DataStruct.Trie;

/**
 * Author:CZD
 * Question:No208ImplementTrie
 * Time:19-3-7 下午1:55
 */
public class No208ImplementTrie {

    public static void main(String args[])
    {
        Trie a=new Trie();
        a.insert("aaa");
        System.out.println(a.search("a"));
    }
}
