class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int sum=0;
        int [] resum= new int[words.length];

        int answer[]= new int[queries.length];

        for(int i=0;i<words.length;i++){
           if((words[i].charAt(0)=='a'||words[i].charAt(0)=='e'||words[i].charAt(0)=='i'||words[i].charAt(0)=='o'||words[i].charAt(0)=='u')
           &&(words[i].charAt(words[i].length()-1)=='a'||words[i].charAt(words[i].length()-1)=='e'||words[i].charAt(words[i].length()-1)=='i'||words[i].charAt(words[i].length()-1)=='o'||words[i].charAt(words[i].length()-1)=='u')){
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