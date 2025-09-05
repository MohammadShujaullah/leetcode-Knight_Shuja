class Solution {
    public int findContentChildren(int[] g, int[] s) {

        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;

            } else {
                j++;
            }

        }
        return count;
    }

    //////-----------------------------Brute force   giving me TLE  -----------------------/////////////////////        
    //     int count = 0;
    //     int n = g.length;
    //     int m = s.length;
    //     Arrays.sort(g);
    //     Arrays.sort(s);

    //     boolean help[] = new boolean[m];
    //     Arrays.fill(help, false);

    //     int max = Integer.MIN_VALUE;

    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             if (s[j] >= g[i] && !help[j]) {
    //                 help[j] = true;
    //                 count++;
    //                 break;

    //             }
    //         }

    //         max = Math.max(max, count);

    //     }
    //     return max;
    // }
}