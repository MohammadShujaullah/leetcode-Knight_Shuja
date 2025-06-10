class Solution {
    public int maxDifference(String s) {
        char ch[]=s.toCharArray();
        Map<Character, Integer> mp = new HashMap<>();

        for (char c : ch) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        }

        int m = Integer.MIN_VALUE;
        int n = Integer.MAX_VALUE;;
        for (int x : mp.values()) {
            if (x % 2 != 0 && x > m) {
                m = x;

            } else if (x % 2 == 0 && n > x) {
                n = x;

            }
        }

        return(m-n);

    }
}