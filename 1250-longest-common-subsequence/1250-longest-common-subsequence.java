class Solution {
    int n;
    int m;
    int DP[][];

    private int solve(String text1, String text2, int i, int j) {
        if (i >= n || j >= m) {
            return 0;

        }
        if (DP[i][j] != -1) {
            return DP[i][j];
        }

        int take = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            return DP[i][j] = 1 + solve(text1, text2, i + 1, j + 1);
        }
        return DP[i][j] = Math.max(solve(text1, text2, i + 1, j), solve(text1, text2, i, j + 1));

    }

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        DP = new int[n + 1][m + 1];
        for (int row[] : DP) {
            Arrays.fill(row, -1);

        }

        return solve(text1, text2, 0, 0);
    }
}