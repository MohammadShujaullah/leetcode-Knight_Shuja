class Solution {
    int n;
    int m;
    int t[][];

    private int solve(int p, int idx, int[][] pairs) {
        if (idx == n)
            return 0;
        

        if(p!=-1 && t[idx][p]!=-1){
            return t[idx][p];
        }

        int take = 0;
        if (p == -1 || pairs[p][1] < pairs[idx][0]) {
            take = 1 + solve(idx, idx + 1, pairs);
        }

        int skip = solve(p, idx + 1, pairs);

        if(p!=-1){
            t[idx][p]= Math.max(skip, take);
        }

        return Math.max(skip, take);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]); // sort in increasing order 
        n = pairs.length;
        t = new int[n][n];
        for (int[] m : t) {
            Arrays.fill(m, -1);
        }

        return solve(-1, 0, pairs);

    }
}