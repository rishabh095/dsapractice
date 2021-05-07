package com.dsa.trie;

public class TrieRepresentation {
    static TrieNode root;

    public static void main(String[] args) {
        root = new TrieNode();
        insertIntoTrie("bad");
        insertIntoTrie("bat");
        insertIntoTrie("bass");
        insertIntoTrie("boss");
        insertIntoTrie("baby");
        insertIntoTrie("apple");
        insertIntoTrie("yellow");
        System.out.println("content of Trie :-");
        displayTrie(root, new char[20], 0);
        System.out.println("bad exists in trie :- " + searchIntoTrie("bad"));
    }

    private static void insertIntoTrie(String key) {
        TrieNode curr = root;
        int index;
        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    private static boolean searchIntoTrie(String key) {
        TrieNode curr = root;
        int index;
        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return (curr != null && curr.isEnd);
    }

    private static void displayTrie(TrieNode root, char[] str, int level) {
        if (root == null)
            return;
        if (root.isEnd) {
            printWord(str, level);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children != null) {
                str[level] = (char) (i + 'a');
                displayTrie(root.children[i], str, level + 1);
            }
        }
    }

    private static void printWord(char[] str, int level) {
        for (int i = 0; i < level; i++)
            System.out.print(str[i]);
        System.out.println();
    }
}
