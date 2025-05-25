class Solution {
    public int longestPalindrome(String[] words) {
        int count = 0;
        HashMap<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            String m = "" + s.charAt(1) + s.charAt(0);
            if (mp.containsKey(m) && mp.get(m) > 0) {

            mp.put(m, mp.get(m) - 1);
                count += 4;

            } else {
                mp.put(s, mp.getOrDefault(s, 0) + 1);

            }

        }

        //now check for equal charecter , and use only 1 baar

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            String l = entry.getKey();
            int co = entry.getValue();

            if ( l.charAt(0) ==l.charAt(1)  && co > 0) {
                count += 2;
                break;
            }

        }

        return count;
    }
}