class Solution {
    public boolean isPalindrome(int x) {            // int to string String.valueOf(num)
        if(x<0)return false;                       //  String to number Integer.valueOf(s) or Integer.parseInt(s)
        

        String num=String.valueOf(x);

        int i=0;
        int j=num.length()-1;
        while(i<=j){

            if(num.charAt(i)!=num.charAt(j)){
                  return false;
            }
            i++;
            j--;
            
        }

        return true;

                           
    }
}