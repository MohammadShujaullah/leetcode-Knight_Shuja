class Solution {
    int t[][];

    private boolean isPredecessor(String prev, String curr) {
        if (prev.length() >= curr.length() || curr.length() - prev.length() != 1)
            return false;

        int i = 0, j = 0;
        while (i < prev.length() && j < curr.length()) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == prev.length();
    }

    private int lis(int p, int idx, String[] words) {
        if (idx == words.length)
            return 0;

        if (p != -1 && t[idx][p + 1] != -1)
            return t[idx][p + 1];

        int take = 0;
        if (p == -1 || isPredecessor(words[p], words[idx])) {
            take = 1 + lis(idx, idx + 1, words);
        }

        int skip = lis(p, idx + 1, words);

        if (p != -1)
            t[idx][p + 1] = Math.max(take, skip);

        return Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {
        int n = words.length;

        //***important sorting syntax */
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length())); // You can select pairs in any order.

        t = new int[n + 1][n + 1]; //extra space for -1 index
        for (int m[] : t) {
            Arrays.fill(m, -1);

        }
        return lis(-1, 0, words);
    }
}