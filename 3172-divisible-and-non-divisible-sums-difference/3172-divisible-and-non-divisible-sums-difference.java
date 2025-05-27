class Solution {
    public int differenceOfSums(int n, int m) {

      int total=(n*(n+1))/2;
      int num1=0;

      int k=(n/m);
      int num2=(m*(k*(k+1))/2);

      num1=total-num2;

        return num1-num2;
    }
}