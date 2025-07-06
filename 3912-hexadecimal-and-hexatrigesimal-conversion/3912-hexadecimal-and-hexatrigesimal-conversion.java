class Solution {
    //   public static String toBase36(int num) {
    //     if (num == 0) return "0";

    //     StringBuilder base36 = new StringBuilder();
    //     char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    //     while (num > 0) {
    //         int remainder = num % 36;
    //         base36.append(digits[remainder]);
    //         num /= 36;
    //     }

    //     return base36.reverse().toString(); // Most significant digit first
    // }



    // we can do manually also , similary for hexa ,just replace 36 by 16
    
    public String concatHex36(int n) {
          int n2 = n * n;
        int n3 = n * n * n;

       // besically , it return lower case ,so we do(.touppercase)
        String hex = Integer.toHexString(n2).toUpperCase();

    
        String base36 = Integer.toString(n3, 36).toUpperCase();

        return hex + base36;
    }
}