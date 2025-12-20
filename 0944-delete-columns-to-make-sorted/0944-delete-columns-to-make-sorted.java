class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int j = 0;

        int count = 0;

        if (n == 2) {
            while (j < m) {

                for (int i = 1; i < n; i++) {

                    if ((strs[i].charAt(j) - 'a' < strs[i - 1].charAt(j) - 'a')) {
                        count++;
                        break;
                    }

                }
                j++;
            }
        } else {
            while (j < m) {

                for (int i = 1; i < n - 1; i++) {

                    if ((strs[i].charAt(j) - 'a' < strs[i - 1].charAt(j) - 'a')
                            || (strs[i].charAt(j) - 'a' > strs[i + 1].charAt(j) - 'a')) {
                        count++;
                        break;
                    }

                }
                j++;
            }
        }

        return count;
    }
}