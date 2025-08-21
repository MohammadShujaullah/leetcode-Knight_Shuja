class Solution {

    // "a good example".split("\\s+") gives:["a", "good", "example"]

    public String reverseWords(String s) {

        String words[] = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0)
                sb.append(" "); //after every word we have to add space 
        }
        return sb.toString();

    }
}