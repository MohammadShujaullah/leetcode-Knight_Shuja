class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();


        for(int n:nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
            
        }

        List<Integer>list=new ArrayList<>(mp.keySet());

        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int x=list.get(i);
                int y=list.get(j);

                if(!mp.get(x).equals(mp.get(y))){
                    return new int []{x,y};
                }
            }
        }

        return new int[]{-1,-1};
        
    }
}