class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        int n = searchWord.length();

        Arrays.sort(products);

        Trie trie = new Trie();

        for(String product : products) {
            trie.insert(product);
        }

        for(int i=1; i<=n; i++) {
            res.add(trie.startsWith(searchWord.substring(0, i)));
        }

        return res;
    }
}

class TrieNode
{
    TrieNode[] child = new TrieNode[26];
    List<String> suggestions = new ArrayList<>();
}

class Trie
{
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

            if(curr.suggestions.size() < 3)
                curr.suggestions.add(word);
        }
    }

    public List<String> startsWith(String prefix) {
        TrieNode curr = root;

        for(char ch : prefix.toCharArray())
        {
            int idx = ch - 'a';

            if(curr.child[idx] == null)
                return new ArrayList<>();

            curr = curr.child[idx];
        }

        return curr.suggestions;
    }
}