class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count=0;
        HashSet<Character>set=new HashSet<>();

        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }

        String words[]=text.split(" ");




        for(String word:words){
             count++;
            for(int i=0;i<word.length();i++){
                if(set.contains(word.charAt(i))){
                    count--;
                    break;
                }
            }
           

        }

        return count;

        
    }
}