class Solution {
    private int find(int i, int parents[]) {
        if (i == parents[i]) {
            return i;

        }
        return parents[i] = find(parents[i], parents);
    }

    private void union(int x, int y, int[] parents, int[] rank) {
        int parent_x = find(x, parents);
        int parent_y = find(y, parents);

        if (parent_x == parent_y)
            return; // Already connected

        if (rank[parent_x] > rank[parent_y]) {
            parents[parent_y] = parent_x;
        } else if (rank[parent_x] < rank[parent_y]) {
            parents[parent_x] = parent_y;
        } else {
            parents[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int rank[] = new int[26];
        int parents[] = new int[26];

        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }

        // for do union of equals chars

        for (String s : equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a', parents, rank);
            }

        }

        /// for != walon ke lie
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int parent_first = find(s.charAt(0) - 'a', parents);
                int parent_second = find(s.charAt(3) - 'a', parents);
                if (parent_first == parent_second) {
                    return false;
                }

            }
        }

        return true;
    }
}