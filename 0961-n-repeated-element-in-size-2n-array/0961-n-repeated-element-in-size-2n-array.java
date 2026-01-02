class Solution {
    public int repeatedNTimes(int[] nums) {
       HashMap<Integer,Integer>mp=new HashMap<>();



        for (int x : nums) {
            mp.put(x,mp.getOrDefault(x,0)+1);

        }
         


 
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();

            if(value==nums.length/2){
                return key;
            }
        }
        return 0;
    }
}