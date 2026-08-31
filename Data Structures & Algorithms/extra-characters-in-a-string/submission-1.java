class TrieNode {
    TrieNode[] child;
    boolean isWord;

    TrieNode() {
        child = new TrieNode[26];
        isWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.child[c - 'a'] == null)
                cur.child[c - 'a'] = new TrieNode();
            cur = cur.child[c - 'a'];
        }
        cur.isWord = true;
    }
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie trie = new Trie();

        for (String word : dictionary)
            trie.addWord(word);
        
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return dfs(0, s, trie, dp);
    }

    private int dfs(int i, String s, Trie trie, int[] dp) {
        if (i == s.length()) return 0;
        if (dp[i] != -1) return dp[i];

        int res = 1 + dfs(i + 1, s, trie, dp);
        TrieNode cur = trie.root;

        for (int j = i; j < s.length(); j++){
            if (cur.child[s.charAt(j) - 'a'] == null) break;
            cur = cur.child[s.charAt((j)) - 'a'];
            if (cur.isWord) res = Math.min(res, dfs(j + 1, s, trie, dp));
        }
        dp[i] = res;
        return res;
    }
}