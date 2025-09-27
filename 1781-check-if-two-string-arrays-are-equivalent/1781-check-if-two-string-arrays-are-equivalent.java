class Solution {

    //time complexity is O(n+m);
    // space complexity O(n+m);  n-is the no. od charecter of woed1, and m is for word2

    // public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    //     String w1=String.join("",word1);
    //     String w2=String.join("",word2);

    //     return w1.equals(w2);
    // }

   public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;   // indices for arrays
        int p1 = 0, p2 = 0; // indices inside strings

        while (i < word1.length && j < word2.length) {
            // compare current characters
            if (word1[i].charAt(p1) != word2[j].charAt(p2)) {
                return false;
            }

            // move pointer inside word1[i]
            p1++;
            if (p1 == word1[i].length()) {
                i++;
                p1 = 0;
            }

            // move pointer inside word2[j]
            p2++;
            if (p2 == word2[j].length()) {
                j++;
                p2 = 0;
            }
        }

        // both arrays should be fully traversed
        return i == word1.length && j == word2.length;
    }
}