// in this question , it is given as strings makes groups and connects each other in same gruop , and some string 
// belongs to another group 
// so , we have to only return how maney group is formed 

// so, it directly shows that it is a graph question,  and easily solved by DFS

class Solution {

    private boolean isSimilar(String s1, String s2) {

        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;

            }
        }

        return diff == 2 || diff == 0;

    }

    private void DFS(Map<Integer, ArrayList<Integer>> mp, int u, boolean visited[]) {
        visited[u] = true;

        if (mp.get(u) != null) {
            for (int v : mp.get(u)) {
                if (!visited[v]) {
                    DFS(mp, v, visited);

                }
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();

        // simply younhave to check the strings present in the strs, that they are identical or not or belongto same grp
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    mp.putIfAbsent(i, new ArrayList<>());
                    mp.putIfAbsent(j, new ArrayList<>());
                    mp.get(i).add(j); // undirected graph
                    mp.get(j).add(i);

                }
            }
        }

        // now map is ready
        int totalgroups = 0;
        boolean visited[] = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                DFS(mp, i, visited);
                totalgroups++;

            }
        }
        return totalgroups;

    }
}