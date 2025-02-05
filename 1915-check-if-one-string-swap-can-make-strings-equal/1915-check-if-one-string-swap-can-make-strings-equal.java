class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;
        int first = -1;
        int second = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s2.charAt(i) != s1.charAt(i)) {
                count++;

                if (count > 2)
                    return false; // if count greater than 2 maens more than one swapping is needed
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                }
            }
        }
        if (count == 0)
            return true;
        else if (count == 2 && s1.charAt(first)==s2.charAt(second) && s1.charAt(second)==s2.charAt(first)) {
            return true;
        }
        return false;
    }
}