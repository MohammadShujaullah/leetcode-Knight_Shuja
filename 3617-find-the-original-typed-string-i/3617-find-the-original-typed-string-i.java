class Solution {
    public int possibleStringCount(String word) {
        int count = 1;

        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

        }

        for (int i = 1; i < word.length(); i++) {

            if (word.charAt(i) == word.charAt(i - 1)) {
                count += 1;
            }
        }
        return count;

    }
}