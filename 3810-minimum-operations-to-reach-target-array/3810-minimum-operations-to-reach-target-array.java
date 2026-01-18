class Solution {
    public int minOperations(int[] nums, int[] target) {
           Set<Integer>vs=new HashSet<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]!=target[i]){
                vs.add(nums[i]);
                
            }
        }


        return vs.size();
    }
}