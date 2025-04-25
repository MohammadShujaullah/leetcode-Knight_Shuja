// we use the binary exponentiation 

class Solution {
    private double solve(double x, int n) {
        if (n == 0 )
            return 1;
        double half = solve(x, n / 2);
        double result = half * half;
        if (n % 2 != 0) {
            return x * result;

        }

        return result;

    }

    public double myPow(double x, int n) {
        if(n<0){
            return 1.0/solve(x,-n);
        }
        return solve(x, n);

    }
}