class Solution {

    // 194/296 test cases from this method

    //this method is for ,when  the number is small 
    // public String addBinary(String a, String b) {
    //     int n1=Integer.parseInt(a,2);
    //     int n2=Integer.parseInt(b,2);
    //     int n3=n1+n2;

    //     return Integer.toBinaryString(n3);

    // }

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';

            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';

            }
            sb.append(sum % 2);

            carry = sum / 2;

        }

        return sb.reverse().toString();

    }
}