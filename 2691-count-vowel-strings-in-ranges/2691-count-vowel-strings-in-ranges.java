class Solution {
    private boolean isvowel(char ch){
        return ch =='a'||ch =='e'||ch =='i'||ch =='o'||ch =='u';
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int sum=0;
        int [] resum= new int[words.length];

        int answer[]= new int[queries.length];

        for(int i=0;i<words.length;i++){
           if(isvowel(words[i].charAt(0))
           && isvowel(words[i].charAt(words[i].length()-1))){
            sum++;
           }
           resum[i]=sum;
        }
        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int l=queries[i][1];
             
             answer[i]=resum[l] -(x>0? resum[x-1]:0);



        }
        return answer;
    }
}