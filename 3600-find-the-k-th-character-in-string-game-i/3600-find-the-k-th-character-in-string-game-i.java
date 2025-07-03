class Solution {

    public char kthCharacter(int k) {
        String binary = Integer.toBinaryString(k - 1);

        int num2 = Integer.parseInt(binary);
        int count = 0;
        while (num2 > 0) {
            int num = num2 % 10;
            if (num == 1) {
                count++;
            }
            num2 /= 10;

        }
        return (char) ('a' + count);
    }
}