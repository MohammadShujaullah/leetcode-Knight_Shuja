class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
      int n = s.length();
        if (k > n) return false;

        for (int i = 0; i <= n - k; i++) {
            // Check if the substring of length k has all the same characters
            char ch = s.charAt(i);
            boolean isValid = true;

            for (int j = i; j < i + k; j++) {
                if (s.charAt(j) != ch) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                // Check the character before and after the substring
                boolean beforeValid = (i == 0 || s.charAt(i - 1) != ch);
                boolean afterValid = (i + k == n || s.charAt(i + k) != ch);

                if (beforeValid && afterValid) {
                    return true;
                }
            }
        }

        return false;      
    }
}