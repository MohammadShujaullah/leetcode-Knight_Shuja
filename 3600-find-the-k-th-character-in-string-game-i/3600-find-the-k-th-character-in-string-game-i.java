class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb1 = new StringBuilder("a");

        while (sb1.length() < k) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < sb1.length(); i++) {
                char ch = (char)(sb1.charAt(i) + 1); // Fixing '1' addition too
                sb2.append(sb1.charAt(i));  // optional: keep original
                sb2.append(ch);
            }
            sb1 = sb2;
        }

        return sb1.charAt(k - 1);
    }
}