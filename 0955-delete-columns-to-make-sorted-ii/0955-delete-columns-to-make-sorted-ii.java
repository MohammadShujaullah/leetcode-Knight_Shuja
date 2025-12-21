class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;

        int m = strs[0].length();

        int count = 0;

        

       

        int j = 0;

        boolean arr[] = new boolean[n];

        while (j < m) {
            boolean deleted = false;
            for (int i = 0; i < n - 1; i++) {

                if (!arr[i] && (strs[i].charAt(j) > strs[i + 1].charAt(j))) {
                    deleted = true;
                    count++;
                    break;

                }

            }

            if (deleted) {
                j++;
                continue;
            }

            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i] || (strs[i].charAt(j) < strs[i + 1].charAt(j));
            }

            j++;
        }

        return count;
    }
}