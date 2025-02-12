class Solution {

    private int find(int i, int parents[]) {
        if (i == parents[i]) {
            return i;

        }
        return parents[i] = find(parents[i], parents);
    }

    private void union(int x, int y, int parents[], int rank[]) {
        // path compresion and rank
        int p_x = find(x, parents);
        int p_y = find(y, parents);

        if (p_x == p_y) {
            return;
        }
        if (rank[p_x] > rank[p_y]) {
            parents[p_y] = p_x;
        } else if (rank[p_x] < rank[p_y]) {
            parents[p_x] = p_y;
        } else {
            parents[p_x] = p_y;
            rank[p_y]++;
        }
    }

    public long countPairs(int n, int[][] edges) {

        int parents[] = new int[n];

        int rank[] = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;

        }
        // step 1

        // make the components

        for (int[] edge : edges) {

            union(edge[0], edge[1], parents, rank);

        }

        // step2
        // make the hashmap ,to store the count of components node in each components

        HashMap<Integer, Integer> map = new HashMap<>();   // <parent,size>
        for (int i = 0; i < n; i++) {
            int papaji=find(i,parents);

           map.put(papaji,map.getOrDefault(papaji,0)+1);

             
        }

        // step3
        long result=0;
        long remainingnode=n;

        for(int i:map.values()){
           result+=i*(remainingnode-i);
           remainingnode-=i;

        }

        return result;

    }
}