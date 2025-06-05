class Solution {
    // this question is realted to hashSet and string 


    private String findRoot(String word, HashSet<String>set){
                              //ye findroot hme String return krega , if word nahi mila to as 
                               //it is word return krega, wrna jo bhi root milga wo return krna ha 

        for(int i=1;i<word.length();i++){
            String x=word.substring(0,i);

            if(set.contains(x)){
                return x;
            }
        }

        return word;


    }
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String>set= new HashSet<>(dictionary);

        StringBuilder result=new StringBuilder();

        String words[]= sentence.split(" ");

        for( String word:words){
              result.append(findRoot(word,set)).append(" ");

        }
        return result.toString().trim();  // to remove the trailing space

    }
}