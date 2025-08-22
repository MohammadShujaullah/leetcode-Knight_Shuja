class Solution {
    // Strictly palindromic means you have to , make palindrom of that number from 2 to n-2 base 

    private boolean ispalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private String convertToBase(int n, int base) {
        StringBuilder sb = new StringBuilder();
        int num=n;
        while (num > 0) { // while loop gives a reverse version of the number you have to change the  the number in by revesrseing it 
    
            int rem = num % base;
            sb.append(rem);
            num = num / base;

        }

        return sb.reverse().toString();

    }

    public boolean isStrictlyPalindromic(int n) {

        for(int i=2;i<=n-2;i++){
            String s=convertToBase(n,i);

            if(!(ispalindrome(s))){
                return false;
            }
        }

        return true;

    }
}