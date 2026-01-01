class Solution {

    int ans[];

    //  method 1: passes the tesecases:93/112

    // public int[] plusOne(int[] digits) {
    //     ArrayList<Integer> list = new ArrayList<>();

    //     for (int i = 0; i < digits.length - 1; i++) {
    //         list.add(digits[i]);
    //     }

    //     if (digits[digits.length - 1] == 9) {
    //         list.add(1);
    //         list.add(0);
    //     } else {
    //         list.add(digits[digits.length - 1] + 1);
    //     }
    //     int[] intArray = list.stream()
    //             .mapToInt(i -> i)
    //             .toArray();
    //     return intArray;
    // }

    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;

        while (i >= 0) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;

            }

            else {
                digits[i] = 0;
                i--;
            }
        }

        int result[] = new int[digits.length + 1];
        result[0] = 1;
        return result;

    }

}