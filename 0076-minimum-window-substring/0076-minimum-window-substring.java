class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        Map<Character, Integer> mp = new HashMap<>();

        for (char c : t.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);

        }

        int countreq = m;
        int minwindow = Integer.MAX_VALUE;
        int start = 0;

        int i = 0;

        for (int j = 0; j < n; j++) {

            if (mp.containsKey(s.charAt(j)) && mp.get(s.charAt(j)) > 0) {

                countreq--;

            }
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) - 1);

            //shrinking 

            while (countreq == 0) {
                if (minwindow > (j - i + 1)) {
                    start = i;
                    minwindow = j - i + 1;

                }
                mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);

                if (mp.getOrDefault(s.charAt(i), 0) > 0) {
                    countreq++;
                }
                i++;

            }
        }

        return minwindow == Integer.MAX_VALUE? "" : s.substring(start, minwindow + start);
    }
}