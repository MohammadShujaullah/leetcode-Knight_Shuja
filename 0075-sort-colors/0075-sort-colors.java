class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>(); //<color,number>

        for (int i = 0; i < nums.length; i++) {

            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);

        }
        int idx=0;
       for(int i=0;i<=2;i++){
        int count=mp.getOrDefault(i,0);

        for(int j=0;j<count;j++){
            nums[idx++]=i;
        }
       }

    }
}