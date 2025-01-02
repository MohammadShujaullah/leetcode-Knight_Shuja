class Solution {
    public int maxScore(String s) {     // this code has three approches ,this is the better approches(2nd approch),and it has a best approch too
        int n = s.length();
        int result = Integer.MIN_VALUE;
        int totalcount1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalcount1++;
            }
        }
        int zero = 0;
        int left1 = 0;
        for (int j = 0; j < n - 1; j++) {

            if (s.charAt(j) == '0') {
                zero++;
            } else {
                left1++;
            }
            int right1 = totalcount1 - left1;
            result = Math.max(result, right1 + zero);

        }
        return result;
    }
}
