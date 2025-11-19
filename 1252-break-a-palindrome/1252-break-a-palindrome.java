class Solution {

    public String breakPalindrome(String palindrome) {
        StringBuilder sb = new StringBuilder(palindrome);

        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != 'a') {

                sb.setCharAt(i, 'a');

                return sb.toString();

            }
        }

        if (sb.length() > 1) {
            sb.setCharAt(sb.length() - 1, 'b');
            return sb.toString();

        }

        return "";

    }
}