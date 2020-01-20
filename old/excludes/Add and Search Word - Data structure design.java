package com.xiangpengli;

public class WordDictionary {


    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
        root.c = "";
    }

    public static void main(String[] args) {
        WordDictionary ins = new WordDictionary();
        ins.addWord("bad");
        ins.addWord("dad");
        ins.addWord("mad");
        System.out.println(ins.search("b.."));
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(node.c + c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = root;
        return searchHelp(word, 0, node);
    }

    private boolean searchHelp(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            return node.children[c - 'a'] != null && searchHelp(word, index + 1, node.children[c - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
               if (node.children[i] != null
                       && searchHelp(word, index + 1, node.children[i])) {
                   return true;
               }
            }

        }

        return false;
    }

    class TrieNode {
        String c;
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        public TrieNode() {
        }

        public TrieNode(String c) {
            this.c = c;
        }
    }

}