class Solution {
    // this question is solved by varible window size of sliding window , and it is same as of leetcode 159
    public int totalFruit(int[] fruits) {
        int maxcount = 0;

        int n = fruits.length;

        Map<Integer, Integer> mp = new HashMap<>();
        int i=0;
        for (int j = 0; j < n; j++) {
            mp.put(fruits[j], mp.getOrDefault(fruits[j], 0) + 1);

            while (mp.size() > 2) { // as i have only 2 basket, so i can put only 2 types of fruits in it 
                mp.put(fruits[i], mp.getOrDefault(fruits[i], 0) - 1);

                if (mp.get(fruits[i]) == 0) {
                    mp.remove(fruits[i]);
                }
                i++;

            }

            maxcount = Math.max(maxcount, j - i + 1);

        }

        return maxcount;
    }
}