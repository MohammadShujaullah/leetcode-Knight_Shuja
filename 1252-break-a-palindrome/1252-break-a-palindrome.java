class Solution {
    private boolean isPalindrome(StringBuilder sb){
        StringBuilder ss=new StringBuilder(sb);
        String rev=ss.reverse().toString();

        return (rev.equals(sb.toString()));
    }
    public String breakPalindrome(String palindrome) {
        StringBuilder sb=new StringBuilder(palindrome);

        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)-'a'>0 && sb.charAt(i)-'a'<=25  ){

                char ch=sb.charAt(i);

                sb.setCharAt(i,'a');

                if(!isPalindrome(sb)){
                    return sb.toString();
                }
                else{
                    sb.setCharAt(i,ch);
                }

            }
        }

        if(sb.length()>1){
            sb.setCharAt(sb.length()-1,'b');
            return sb.toString();
            
        }

        
        return "";

    }
}