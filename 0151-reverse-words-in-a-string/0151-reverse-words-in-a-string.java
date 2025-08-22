class Solution {

    // "a good example".split("\\s+") gives:["a", "good", "example"]

    // public String reverseWords(String s) {

    //     String words[] = s.trim().split("\\s+");

    //     StringBuilder sb = new StringBuilder();

    //     for (int i = words.length - 1; i >= 0; i--) {
    //         sb.append(words[i]);
    //         if (i > 0)
    //             sb.append(" "); //after every word we have to add space 
    //     }
    //     return sb.toString();

    // }

    //-----------------------------by using constant space --------------------//
    private String removespace(String s) {
        StringBuilder sb = new StringBuilder(s);

        // Remove leading spaces
        while (sb.length() > 0 && sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }

        // Remove trailing spaces
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // Remove multiple spaces in the middle
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ' && sb.charAt(i - 1) == ' ') {
                sb.deleteCharAt(i);
                i--; // recheck after deletion
            }
        }

        return sb.toString();
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        String m = removespace(s);
        int j = m.length() - 1;
        int i = m.length() - 1;
        while (i >= 0) {
            if (m.charAt(i) != ' ') {
                while (j >= 0 && m.charAt(j) != ' ') {
                    j--;
                }

                int x = j + 1;
                while (x <= i) {
                    sb.append(m.charAt(x));
                    x++;
                }
                if (j > 0 && m.charAt(j) == ' ')
                    sb.append(' ');

            } else {
                i--;
                j = i;
                continue;
            }
            i = j - 1;
            j = i;
        }
        return sb.toString();
    }

}