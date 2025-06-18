class Solution {

    public int generateKey(int num1, int num2, int num3) {

        int  ans = 0;

        String f1 = String.format("%04d", num1);
        String f2 = String.format("%04d", num2);
        String f3 = String.format("%04d", num3);

        int n1 = Integer.parseInt(f1);
        int n2 = Integer.parseInt(f2);
        int n3 = Integer.parseInt(f3);

        for (int i = 0; i < 4; i++) {
            int digit = Math.min(n1 % 10,Math.min( n2 % 10, n3 % 10));
             ans = digit *(int) Math.pow(10, i) + ans;

            n1=n1/10;
            n2=n2/10;
            n3=n3/10;

        }

        return ans;

    }
}