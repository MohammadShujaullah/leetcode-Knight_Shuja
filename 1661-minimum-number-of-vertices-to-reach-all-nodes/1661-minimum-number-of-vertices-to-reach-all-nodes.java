// her we use the concept of indegree, as any vertex whose indegree is zero, then it must be in the result 

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer,ArrayList<Integer>>mp= new HashMap<>();
        Map<Integer,Integer>indegree= new HashMap<>();


        for(List<Integer> x:edges){
            mp.putIfAbsent(x.get(0),new ArrayList<>());
            mp.get(x.get(0)).add(x.get(1));

            indegree.put(x.get(1),indegree.getOrDefault(x.get(1),0)+10);
            // those who has no indegree, they are not present in the above map

        }

        boolean visited[]=new boolean[n];
    List<Integer>result= new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!indegree.containsKey(i)){
                result.add(i);
                // DFS(mp,i,visited);
                
            }
        }
        return result;
       
    }
}