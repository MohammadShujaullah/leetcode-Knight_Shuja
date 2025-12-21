class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

        }

   int count=0;
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            int x=entry.getValue();

            if(x==1){
                return -1;
            }
            else if(x%3==1){
            count+=(x/3-1)+2;

            
            }
            else if(x%3==2){
                count+=(x/3)+1;
            }
            else if(x%3==0){
                count+=x/3;
            }
        }

        return count;
    }
}