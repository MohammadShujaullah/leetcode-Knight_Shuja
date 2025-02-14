class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>winners= new ArrayList<>();
        List<Integer>runner=new ArrayList<>();


        HashMap<Integer,Integer>mp =new HashMap<>();

        for(int []v:matches){

            mp.put(v[1],mp.getOrDefault(v[1],0)+1);    // making a map to store who is losses ,how many games

        }


        // now traverse on the map 
        for(int []v:matches){
            int winner=v[0];
            int losser=v[1];


            if(!mp.containsKey(winner)){
                winners.add(winner);
                mp.put(winner,2);

            }
            if(mp.get(losser)==1){
                runner.add(losser);

            }
        }
        Collections.sort(winners);
        Collections.sort(runner);
        result.add(winners);
        result.add(runner);

        return result;


    }
}