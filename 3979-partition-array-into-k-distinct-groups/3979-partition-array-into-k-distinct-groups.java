class Solution {
    public boolean partitionArray(int[] nums, int k) {
     
        if ( nums.length % k!= 0)
            return false;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int n : nums) {
            mp.put(n, mp.getOrDefault(n, 0) + 1);

        }
           int grp=nums.length /k;
        for (int m : mp.values()) {
            if (grp<m ) {         // previously i added the condition of  (m>k)   , which is wrong in case of the [49,37,57,34,106,46,37,69,58,103], k=1 
                return false;
            }

        }


        return true;

    }
}