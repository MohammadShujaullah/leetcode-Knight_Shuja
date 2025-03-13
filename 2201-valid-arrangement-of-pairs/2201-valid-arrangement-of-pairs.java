class Solution {

    // map to make the adjecency list
    HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

    // list to store the eulerian path
    ArrayList<Integer>eularpath= new ArrayList<>();

    ///////////////////////////////////////////////////

    private void DFS(int node) {
        while (mp.containsKey(node) && !mp.get(node).isEmpty()) {
            int nextnode = mp.get(node).remove(mp.get(node).size() - 1); // removethe next node after saving , so that
                DFS(nextnode);                                                          // it will doesnt repeat itself
        }
        eularpath.add(node);     // Add node to Euler path after all edges are visited
    }
    /////////////////////////////////////////////////////

    public int[][] validArrangement(int[][] pairs) { // let this be a directed graph

        // indegree and outdegree
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        // step1 populate the graph using pairs[][]
        for (int[] pair : pairs) {
            mp.putIfAbsent(pair[0], new ArrayList<>());
            mp.get(pair[0]).add(pair[1]);

            outDegree.put(pair[0], outDegree.getOrDefault(pair[0], 0) + 1);
            inDegree.put(pair[1], inDegree.getOrDefault(pair[1], 0) + 1);

        }

        // step2
        // Step-2: Find the start node of the Eulerian path

        int startnode = pairs[0][0];
        for (int node : mp.keySet()) {
            if (outDegree.getOrDefault(node, 0) - inDegree.getOrDefault(node, 0)==1) {
                startnode = node;
                break;

            }
        }

        // Step-3: Perform DFS from the start node to find the Eulerian path
        DFS(startnode);



  // Step-4: Build the result from the Eulerian path
        //reverse the eularpath
        Collections.reverse(eularpath);

        int result[][]= new int [eularpath.size()-1][2];

        for(int i=0;i<eularpath.size()-1;i++){
            result[i][0]=eularpath.get(i);
             result[i][1]=eularpath.get(i+1);
           
        }
        return result;

    }
}