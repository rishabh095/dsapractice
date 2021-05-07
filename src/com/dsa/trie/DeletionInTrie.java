package com.dsa.trie;

public class DeletionInTrie {
    static TrieNode root;

    public static void main(String[] args) {
        root = new TrieNode();
        insertIntoTrie("bad");
        insertIntoTrie("bat");
        insertIntoTrie("bass");
        insertIntoTrie("boss");
        insertIntoTrie("baby");
        insertIntoTrie("babyi");
        insertIntoTrie("apple");
        insertIntoTrie("yellow");
        System.out.println("content of Trie :-");
        displayTrie(root, new char[20], 0);
        System.out.println("baby exists in trie :- " + searchIntoTrie("baby"));
        System.out.println("babyi exists in trie :- " + searchIntoTrie("babyi"));
        System.out.println("yellow exists in trie :- " + searchIntoTrie("yellow"));
        deleteFromTrie(root,"yellow",0);
        deleteFromTrie(root,"baby",0);
        displayTrie(root, new char[20], 0);
        System.out.println("yellow exists in trie :- " + searchIntoTrie("yellow"));
        System.out.println("baby exists in trie :- " + searchIntoTrie("baby"));
        System.out.println("babyi exists in trie :- " + searchIntoTrie("babyi"));
    }

    private static TrieNode deleteFromTrie(TrieNode root, String key, int level) {
        if(root==null)
            return null;
        if(level==key.length()){
            if(root.isEnd)
                root.isEnd=false;
            if(isEmpty(root))
                root=null;
            return root;
        }
        int index=key.charAt(level)-'a';
        root.children[index]=deleteFromTrie(root.children[index],key,level+1 );
        if(isEmpty(root) && !root.isEnd)
            root= null;
        return root;
    }

    private static boolean isEmpty(TrieNode root) {
        for (int i=0;i<26;i++){
            if(root.children[i] !=null)
                return false;
        }
        return true;
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
        if (root.isEnd)
            printWord(str, level);
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
