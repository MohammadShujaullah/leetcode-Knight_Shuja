// after the observation in question we can se ,that total  for even index 5^(n+1)/2  and for odd index 4^(n/2)

// so total we have to take  answer= 5^(n+1)/2  *   4^(n)/2 
 class Solution {
    long M = (long)1e9 + 7;

    private long powerCalculation(long m, long num) {
        if (num == 0) return 1;

        long half = powerCalculation(m, num / 2);
        long result = (half * half) % M;

        if (num % 2 == 1) {
            result = (result * m) % M;
        }

        return result;
    }

    public int countGoodNumbers(long n) {
        long odd = powerCalculation(5, (n + 1) / 2);
        long even = powerCalculation(4, n / 2);
        return (int)((odd * even) % M);
    }
}
