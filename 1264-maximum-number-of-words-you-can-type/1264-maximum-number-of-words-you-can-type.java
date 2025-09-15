class Solution {
    // public int canBeTypedWords(String text, String brokenLetters) {
    //     int count=0;
    //     HashSet<Character>set=new HashSet<>();

    //     for(int i=0;i<brokenLetters.length();i++){
    //         set.add(brokenLetters.charAt(i));
    //     }

    //     String words[]=text.split(" ");

    //     for(String word:words){
    //          count++;
    //         for(int i=0;i<word.length();i++){
    //             if(set.contains(word.charAt(i))){
    //                 count--;
    //                 break;
    //             }
    //         }

    //     }

    //     return count;
    //}
    //-------------------------/// above code , beats 92%----------------------------------

    public int canBeTypedWords(String text, String brokenLetters) {

        // we use 26 sized arraY 

        boolean mp[] = new boolean[26];

        for (int i = 0; i < brokenLetters.length(); i++) {
            mp[brokenLetters.charAt(i) - 'a'] = true;
        }

        boolean notbrk = true;
        int result = 0;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == ' ') {

                if (notbrk == true) {
                    result++;

                }
                notbrk = true; // reset for another word 
            } else if (mp[text.charAt(i) - 'a'] == true) {
                notbrk = false;

            }

        }

        if (notbrk) {
            result++;
        }

        return result;
    }

}