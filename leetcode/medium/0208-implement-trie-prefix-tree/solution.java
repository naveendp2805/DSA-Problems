class TrieNode
{
    TrieNode[] child = new TrieNode[26];
    Boolean isEnd = false;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray())
        {
            int idx = ch - 'a';

            if(curr.child[idx] == null)
                curr.child[idx] = new TrieNode();

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray())
        {
            int idx = ch - 'a';

            if(curr.child[idx] == null)
                return false;

            curr = curr.child[idx];
        }

        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char ch : prefix.toCharArray())
        {
            int idx = ch - 'a';

            if(curr.child[idx] == null)
                return false;

            curr = curr.child[idx];
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