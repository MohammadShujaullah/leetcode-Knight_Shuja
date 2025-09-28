class Solution {
    public int balancedString(String s) {
        //WE ARE USING SLIDING WINDOW FOR THIS QUESTION , 
        //AS inside inside sliding window , we have to store the substring which
        // we have to remove , so that the outside of the string is balanced 

        int n = s.length();
        int target = n / 4;
        // we are using map for frequncy to store the freq.
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

        }

        if (mp.getOrDefault('Q', 0) == target &&
                mp.getOrDefault('W', 0) == target &&
                mp.getOrDefault('E', 0) == target &&
                mp.getOrDefault('R', 0) == target) {
            return 0;
        }

        int res = n;
        int right = 0;
        int left = 0;

        for (right = 0; right < n; right++) {
            char ch = s.charAt(right);
            mp.put(ch, mp.get(ch) - 1);

            while (left < n && mp.getOrDefault('Q', 0) <= target &&
                    mp.getOrDefault('W', 0) <= target &&
                    mp.getOrDefault('E', 0) <= target &&
                    mp.getOrDefault('R', 0) <= target) {

                // update result BEFORE restoring left char
                res = Math.min(res, right - left + 1);

                // now restore left char and move left pointer
                char ch1 = s.charAt(left);
                mp.put(ch1, mp.get(ch1) +1);

                left++;

            }
        }

        return res;

    }
}