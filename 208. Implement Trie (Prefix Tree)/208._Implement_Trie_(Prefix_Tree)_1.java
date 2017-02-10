class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> mapChildren;
    boolean ifEnd = false;
    public TrieNode() {
        mapChildren = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode add(char child) {
        if (!mapChildren.containsKey(child)) 
            mapChildren.put(child, new TrieNode());
        return mapChildren.get(child);
    }
    
    public TrieNode get(char child) {
        if (!mapChildren.containsKey(child))
            return null;
        return mapChildren.get(child);
    }
    
    public void setEnd() {
        this.ifEnd = true;
    }
    
    public boolean ifEnd() {
        return this.ifEnd;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++)
            current = current.add(word.charAt(i));
        current.setEnd();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            current = current.get(word.charAt(i));
            if (current == null)
                return false;
        }
        return current.ifEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            current = current.get(prefix.charAt(i));
            if (current == null)
                return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");