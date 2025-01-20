class Solution {
    private boolean isvalid(String w1, String w2) {

        // if w1 is larger than w2 then it cannot be a valid preffix ans suffix
        if (w1.length() > w2.length()) {
            return false;
        }
       boolean isprefix = false;
       boolean issuffix = false;

        // check for prefix
        int i = 0;
        int j = 0;
        while (i < w1.length()) {
            if (w1.charAt(i) == w2.charAt(j)) {// comparing the character with each other
                i++;
                j++;
            } else {
                break;
            }

        }
        if (i == w1.length()) {
            isprefix = true;
        }
        // check for suffix
        int m = w1.length() - 1;
        int n = w2.length() - 1;
        while (m >= 0) {
            if (w1.charAt(m) == w2.charAt(n)) {
                m--;
                n--;
            } else {
                break;
            }

        }
        if (m < 0) {
            issuffix = true;
        }

        return isprefix && issuffix;

    }

    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isvalid(words[i], words[j])) { /// alwaqys j>i means w1 shold larger than w2
                    count++;
                }
            }
        }
        return count;
    }
}
