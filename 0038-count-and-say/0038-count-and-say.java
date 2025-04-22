class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";

        }

        String say = countAndSay(n-1);
           String result="";
        // now we doing processing 
        for(int i=0;i<say.length();i++){
            char ch=say.charAt(i);
            int count=1;
         

            while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1)){// to know the number of equal strings
                  count++;
                  i++;

            }
            result+=count+""+ch;

        }
        return result;

    }
}