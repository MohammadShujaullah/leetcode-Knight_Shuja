class Solution {
    // int n;
    // int m;
    // int DP[][];

    // private int solve(String text1, String text2, int i, int j) {
    //     if (i >= n || j >= m) {
    //         return 0;

    //     }
    //     if (DP[i][j] != -1) {
    //         return DP[i][j];
    //     }

    //     int take = 0;
    //     if (text1.charAt(i) == text2.charAt(j)) {
    //         return DP[i][j] = 1 + solve(text1, text2, i + 1, j + 1);
    //     }
    //     return DP[i][j] = Math.max(solve(text1, text2, i + 1, j), solve(text1, text2, i, j + 1));

    // }

    // public int longestCommonSubsequence(String text1, String text2) {
    //     n = text1.length();
    //     m = text2.length();
    //     DP = new int[n + 1][m + 1];
    //     for (int row[] : DP) {
    //         Arrays.fill(row, -1);

    //     }

    //     return solve(text1, text2, 0, 0);
    // }

    //------------------recursion+memo-------------------//




    // public int longestCommonSubsequence(String s1, String s2) {
    //     int m = s1.length();
    //     int n = s2.length();

    // // t[i][j] denotes longest commom subsequence b/w s1 lof length i and s2 of length j-----------
    //     int t[][] = new int[m + 1][n + 1];

    //     //first cloumn and row wiil be zero 

    //     for (int row = 0; row < m + 1; row++) {
    //         t[row][0] = 0;
    //     }
    //     for (int col = 0; col < n + 1; col++) {
    //         t[0][col] = 0;
    //     }

    //     for (int i = 1; i < m + 1; i++) {
    //         for (int j = 1; j < n + 1; j++) {
    //             if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
    //                 t[i][j] = 1 + t[i - 1][j - 1];    // main 1 add krunga if , same char milta ha to ,and then go for t[i+1][j+1] for further calculation , but it goes out of bond ,when reavches to m,n  // so we take t[i-1][j-1]
    //             } else {
    //                 t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
    //             }
    //         }
    //     }

    //     return t[m][n];

    //-------bottom up---------------------//




    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // t[i][j] denotes longest commom subsequence b/w s1 lof length i and s2 of length j-----------
        int t[][] = new int[m + 1][n + 1];

        //first cloumn and row wiil be zero 

        for (int row = 0; row < m + 1; row++) {
            t[row][0] = 0;
        }
        for (int col = 0; col < n + 1; col++) {
            t[0][col] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1]; // main 1 add krunga if , same char milta ha to ,and then go for t[i+1][j+1] for further calculation , but it goes out of bond ,when reavches to m,n  // so we take t[i-1][j-1]
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        StringBuilder ss = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ss.append(s1.charAt(i - 1));
                i--;
                j--;

            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    i--;

                } else {
                    j--;
                }
            }
        }

        System.out.println(ss.reverse().toString());

        return t[m][n];



////----this solution is to bottom up with print of longest comman subsequence----------///
    }
}