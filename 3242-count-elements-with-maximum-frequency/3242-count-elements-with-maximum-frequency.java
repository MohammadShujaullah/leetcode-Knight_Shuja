class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

        }
        int max=0;

        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();

            if(value>max){
                max=value;

            }
        }
        int count=0;

        for(int x:mp.keySet()){
            if(mp.get(x)==max){
                count+=max;
            }
        }

        return count;



    }
}