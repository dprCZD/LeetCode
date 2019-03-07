package DataStruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:CZD
 * Question:TrieNode
 * Time:19-3-7 下午2:09
 */
public class TrieNode {

    private String data;

    private boolean isWord=false;

    private Map<Character, TrieNode> subNodes;

    public TrieNode(String data) {
        this.data=data;
        subNodes=new HashMap<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public Map<Character, TrieNode> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(Map<Character, TrieNode> subNodes) {
        this.subNodes = subNodes;
    }
}
