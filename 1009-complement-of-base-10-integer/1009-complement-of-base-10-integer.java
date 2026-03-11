class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder Binary = new StringBuilder(Integer.toBinaryString(n));

        for (int i = 0; i < Binary.length(); i++) {
            if (Binary.charAt(i) == '0') {
                Binary.setCharAt(i, '1');

            } else {
                Binary.setCharAt(i, '0');

            }

        }


        return Integer.parseInt(Binary.toString(),2);
    }
}