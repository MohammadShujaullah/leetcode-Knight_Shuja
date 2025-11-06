class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freqmap = new HashMap<>();
        // [populate the map with t string ]
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freqmap.put(ch, freqmap.getOrDefault(ch, 0) + 1);

        }
        int uniquecharcount = freqmap.size();
        int startidx = -1;
        int windowstart = 0;
        int windowend = 0;
        int minlen = Integer.MAX_VALUE;
        int n = s.length();
        while (windowend < n) {
            char ch = s.charAt(windowend);
            if (freqmap.containsKey(ch)) {
                // expanding phase
                freqmap.put(ch, freqmap.get(ch) - 1);
                if (freqmap.get(ch) == 0) {
                    uniquecharcount--;
                }
            }
            // shrinking phase
            while (uniquecharcount == 0) {
                // finding length
                int len = windowend - windowstart + 1;
                if (len < minlen) {
                    minlen = len;
                    startidx = windowstart;

                }
                ch = s.charAt(windowstart);
                if (freqmap.containsKey(ch)) {
                    freqmap.put(ch, freqmap.get(ch) + 1);
                    if (freqmap.get(ch) > 0) {
                        uniquecharcount++;
                    }
                }
                windowstart++;

            }

            windowend++;

        }
        if (startidx == -1) {
            return "";

        }
        return s.substring(startidx, startidx + minlen);

    }
}