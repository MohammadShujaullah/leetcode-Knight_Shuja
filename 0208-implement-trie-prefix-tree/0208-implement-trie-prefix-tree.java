 class Node {
    Node[] children = new Node[26];
    boolean eow;

    public Node() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

class Trie {

    public static Node root;

    public Trie() { // constructor if trie
        root = new Node();
    }

    public void insert(String word) {
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public boolean startsWith(String prefix) { // if the prifix is exist return true
        int level = 0;
        int len = prefix.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = prefix.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
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
 */