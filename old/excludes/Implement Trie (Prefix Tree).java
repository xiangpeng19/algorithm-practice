package excludes;

class TrieNode {
    char c;
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
    public TrieNode() {

    }
    public TrieNode(char c) {
        this.c = c;
    }

}

public class Trie {

    private TrieNode root;


    public static void main(String[] args) {
        Trie ins = new Trie();
        ins.insert("a");
        System.out.println(ins.startsWith("a"));

    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.isWord = false;
        root.c = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;


    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
        }

        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 **/