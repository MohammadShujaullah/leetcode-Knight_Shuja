class Solution {

    private boolean isVowel(char ch) {
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    // public String sortVowels(String s) {
    //     StringBuilder sb = new StringBuilder(s);

    //     for (int i = 0; i < sb.length(); i++) {
    //         if (isVowel(sb.charAt(i))) {
    //             for (int j = i + 1; j < sb.length(); j++) {
    //                 if (isVowel(sb.charAt(j)) && sb.charAt(i) - 'A' > sb.charAt(j) - 'A') {
    //                     char temp = sb.charAt(i);
    //                     sb.setCharAt(i, sb.charAt(j));
    //                     sb.setCharAt(j, temp);
    //                 }
    //             }
    //         }

    //     }

    //     return sb.toString();

    // }
 public String sortVowels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }

        String vowels = "AEIOUaeiou";
        int j = 0; // pointing to temp (current vowel)

        char[] resultArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                while (map.getOrDefault(vowels.charAt(j), 0) == 0) {
                    j++;
                }

                resultArray[i] = vowels.charAt(j);
                map.put(vowels.charAt(j), map.get(vowels.charAt(j)) - 1);
            }
        }

        return new String(resultArray);
    }

}