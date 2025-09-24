class Solution {

    int MOD = (int) (1e9 + 7);

    private long factorial(int num) {

        long fact=1;

        for (int i = 1; i <= num; i++) {
            fact =  (fact* i) % MOD;  

            // after every multiplication the value, goes beyond their limit, so for every multiply we have to tak ehte Mod Of it 
        }

        return fact;
    }

    public int numPrimeArrangements(int n) {

        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        // intitally we put all the true 

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) { // we have to go till the root (n ), only 
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int countprim = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                countprim++;
            }
        }

        int comp = n - countprim;

        return (int)((factorial(countprim) * factorial(comp)) % MOD);

        // even thought the number is small due to taking MOD of number, but here we are taking multiplication of two factorial , so we again take the MOD

    }
}