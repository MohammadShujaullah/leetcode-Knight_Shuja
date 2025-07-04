class Solution {
    int x;
    int y;
    int z;
    private final int MOD = 1000000007;
    int t[][][];

    private int solve(int idx, int count, int max) {
        if (idx == x) {
            if (count == z) {
                return 1;
            }
            return 0;
        }

        if ( t[idx][count][max] != -1) {
            return t[idx][count][max];
        }

        int result = 0;

        for (int i = 1; i <= y; i++) {
            if (i > max) {
                result = (result + solve(idx + 1, count + 1, i)) % MOD;
            } else {
                result = (result + solve(idx + 1, count, max)) % MOD;
            }
        }

        return t[idx][count][max] = result % MOD;

    }

    public int numOfArrays(int n, int m, int k) {
        if (m < k)
            return 0;

        x = n;
        y = m;
        z = k;
        t = new int[51][51][101];

        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(t[i][j], -1);

            }
        }

        return solve(0, 0, 0);
    }
}