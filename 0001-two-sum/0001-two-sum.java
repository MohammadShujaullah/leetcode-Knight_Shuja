class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int n = nums.length;
        // int ans[]=new int[2];
        // for (int i = 0; i < n; i++) {
        //     int remain = target - nums[i];
        //     for (int j = i + 1; j < n; j++) {
        //          if(nums[j]==remain){
        //             return new int[]{i,j};
        //          }
        //     }
        // }
        // return ans;

        int n = nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
           int complement=target-nums[i];
           if(mp.containsKey(complement)){
             return new int[]{mp.get(complement),i};
           }
           mp.put(nums[i],i);

        }

        return new int[0];



    }
}