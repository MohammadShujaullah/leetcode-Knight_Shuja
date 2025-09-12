class Solution {

    private boolean isVowel(char ch) {
        char m = Character.toLowerCase(ch);
        if (m == 'a' || m == 'e' || m == 'i' || m == 'o' || m == 'u') {
            return true;
        }
        return false;
    }

    public boolean doesAliceWin(String s) {

        int count = 0;

        for (int i=0;i<s.length();i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        if (count == 0)
            return false;

        if (count % 2 == 1 || count%2==0)
            return true;
        
        // boolean oddtrue=true;
        // int vowelcount=0;
        // for(int i=0;i<s.length();i++){
        //      if(oddtrue && isVowel(s.charAt(i))){

        //         vowelcount++;
        //         if(vowelcount=count-1 || vowelcount%2==1){
        //             oddtrue=false;
        //         }

        //      }
        //      else if(!oddtrue && !isVowel(s.charAt(i))){
        //         voowelcount=0;
        //         oddtrue=true;
        //      }
        // }
        // return false;    

      


        return false;

    }
}