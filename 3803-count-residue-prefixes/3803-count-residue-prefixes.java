class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> st = new HashSet<>();
        int count = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!st.contains(s.charAt(i))) {
                st.add(s.charAt(i));
                if (st.size() == (i + 1) % 3) {
                    count++;
                }

            } else if (st.size() == (i + 1) % 3) {
                count++;
            }

        }

        return count;
    }
}