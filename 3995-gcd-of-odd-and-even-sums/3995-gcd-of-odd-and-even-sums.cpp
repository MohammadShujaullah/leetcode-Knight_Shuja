class Solution {
public:
    int gcdOfOddEvenSums(int n) {
        int sumodd=n*n;
        int sumeven=n+n*n;

       return __gcd(sumodd,sumeven); 

    }
};