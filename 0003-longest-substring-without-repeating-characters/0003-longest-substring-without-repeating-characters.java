class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashSet<Character> set = new HashSet<>();

        int max = 0;

        int i = 0;
        int j = 0;

        while (j < n) {
            //shriking
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;

            }

            set.add(s.charAt(j));

            max = Math.max(max, j - i + 1);

            j++;
        }

        return max;
    }
}