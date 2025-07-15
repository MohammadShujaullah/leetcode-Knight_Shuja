class Solution {

    public boolean isValid(String word) {
       if(word.length()<3)return false;

     

       boolean isNumber=false;
       boolean isVowel=false;
       boolean isConsonent=false;

       for(char ch:word.toCharArray()){
          if(Character.isLetter(ch)){
            char m=Character.toLowerCase(ch);
            if(m=='a'||m=='e'||m=='i'||m=='o'||m=='u'){
                isVowel=true;
            }
            else{
                isConsonent=true;
            }
           

          } else if((!Character.isDigit(ch))){
                 return false;
            }
          

       }

       return   isConsonent && isVowel;
    

    }
}