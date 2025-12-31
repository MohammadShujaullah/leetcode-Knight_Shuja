class Solution {
    public int partitionString(String s) {
        int count = 0;
        int start = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mp.containsKey(ch) && mp.get(ch) >= start) {
                count++;
                start = i;
            } 
                mp.put(ch, i);

            

        }

        return count+1;
    }
}