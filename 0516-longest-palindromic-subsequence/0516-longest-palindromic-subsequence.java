class Solution {
    // after observation this will solve by lonh=gest common subsequence code 

    int n;
    int t[][];

    private int solve(String s, int i, int j) {
        if (i > j) {
            return 0; /// empty string is apalindrome with length 0 
        }
        if (i == j) {
            return 1; // as single charecter in the string is present 
        }

        if (t[i][j] != -1)
            return t[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return t[i][j] = 2 + solve(s, i + 1, j - 1);
        }
        return t[i][j] = Math.max(solve(s, i + 1, j), solve(s, i, j - 1));

    }

    public int longestPalindromeSubseq(String s) {

        n = s.length();
        t = new int[n + 1][n + 1];

        for (int row[] : t) {
            Arrays.fill(row, -1);
        }

        return solve(s, 0, n - 1);

    }
}