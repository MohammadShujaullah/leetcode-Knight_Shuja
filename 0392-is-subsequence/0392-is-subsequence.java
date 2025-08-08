class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0) {
            return true;
        }

        int n = t.length();
        int m = s.length();

        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(j) == t.charAt(i)) {

                j++;
            }
            i++;

        }

        if (i >= n && j >= m) {
            return true;
        } else if (j >= m) {
            return true;
        }

        return false;

    }
}