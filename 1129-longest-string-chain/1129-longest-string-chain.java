class Solution {

    private boolean isPredecessor(String prev, String curr) {
        if (prev.length() >= curr.length() || curr.length() - prev.length() != 1)
            return false;

        int i = 0, j = 0;
        while (i < prev.length() && j < curr.length()) {
            if (prev.charAt(i) == curr.charAt(j)) { //If they don’t match, skip one character from curr (i.e., increment only j).

                //This simulates "inserting" one character into prev.
                i++;
            }
            j++;
        }
        return i == prev.length();
    }

    // private int lis(int p, int idx, String[] words) {
    //     if (idx == words.length)
    //         return 0;

    //     if (p != -1 && t[idx][p + 1] != -1)
    //         return t[idx][p + 1];

    //     int take = 0;
    //     if (p == -1 || isPredecessor(words[p], words[idx])) {
    //         take = 1 + lis(idx, idx + 1, words);
    //     }

    //     int skip = lis(p, idx + 1, words);

    //     if (p != -1)
    //         t[idx][p + 1] = Math.max(take, skip);

    //     return Math.max(take, skip);
    // }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int maxlis = 1; // because bydefault the subsequece is 1

        //***important sorting syntax */
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length())); // You can select pairs in any order.

        int t[] = new int[n];
        Arrays.fill(t, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    t[i] = Math.max(t[i], t[j] + 1);

                    maxlis = Math.max(maxlis, t[i]);
                }
            }
        }
        return maxlis;

    }
}