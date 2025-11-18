class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = n - 1;
        int j = n - 2;
        if (n == 1 && bits[i] == 0) {
            return true;
        } else if (bits[i] == 1) {
            return false;
        }

        int x = 0;

        while (x < n - 1) {
            if (bits[x] == 1) {
                x += 2;

            } else {
                x += 1;
            }
        }

        if (x >= n) {
            return false;
        }

        return true;
    }
}