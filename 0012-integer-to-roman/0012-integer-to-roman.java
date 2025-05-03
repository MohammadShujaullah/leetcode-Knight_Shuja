// purely mathematiocal question 

// sybol and values are givrn 
class Solution {
    public String intToRoman(int num) {
        // firastly we made arrays fto stores the symbole and vslues of given in questuon 

        int val[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String symb[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X","IX", "V", "IV", "I" };

        String result = "";
        for (int i = 0; i < 13; i++) { // no. of terms in above arrays are 13

            if (num == 0)
                break;

            int times = num / val[i];

            while (times-- > 0) {
                result += symb[i];

            }
            num = num % val[i];

        }

        return result;

    }
}