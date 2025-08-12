class Solution {
    boolean t[][];

    private boolean solve(String s, int i, int j) {

        if(i>=j) return true;

        if (t[i][j] != false)
            return true;

        if(s.charAt(i)==s.charAt(j)){
            return t[i][j]= solve(s,i+1,j-1);
        }
        
            return t[i][j]=false;
           

        
         
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int maxlength = Integer.MIN_VALUE;
        t = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (solve(s, i, j)) {
                    int count = j - i + 1;

                    if (count > maxlength) {
                       
                        maxlength = count;
                         start = i;
                    }

                }

            }
        }

       

        return s.substring(start,start+maxlength);  // exclusive index at right

    }
}