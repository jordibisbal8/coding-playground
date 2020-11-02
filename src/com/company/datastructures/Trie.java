package com.company.datastructures;

public class Trie {

    private TrieNode root;

    private class TrieNode {
        Integer ALPHABET_SIZE = 52; //also for capital letters
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
        }
    }
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            int index = ch - 'A';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        return p != null && p.isWord;
    }

    public TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            int index = ch - 'A';
            if (current.children[index] != null)
                current = current.children[index];
            else return null;
        }
        if (current == root) return null;
        return current;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        return p != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Jordi");
        trie.insert("Jor");
        trie.insert("Nadine");
        System.out.print(trie.search("Jordi"));
        System.out.print(trie.search("Jord"));
        System.out.print(trie.startsWith("Jord"));
    }
}
