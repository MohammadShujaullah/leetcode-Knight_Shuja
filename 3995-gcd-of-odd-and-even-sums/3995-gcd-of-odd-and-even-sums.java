import java.math.BigInteger;

class Solution {
    // doing it throught the use of BighInteger
    public int gcdOfOddEvenSums(int n) {
        BigInteger oddsum=BigInteger.valueOf(n*n);
                BigInteger evensum=BigInteger.valueOf(n+n*n);

                BigInteger gcd=oddsum.gcd(evensum);

                return gcd.intValue();

    }
}