class Solution {
    public int findLHS(int[] nums) {

        int max =0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int n : nums) {
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        for (int key : mp.keySet()) {
            if (mp.containsKey(key + 1)) { // its a O(1) work
                max = Math.max(max, mp.get(key) + mp.get(key + 1));

            }
        }

        return max;
    }
}