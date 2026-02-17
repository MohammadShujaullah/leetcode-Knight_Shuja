class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();

        for(String w:words){
            int sum=0;

            for(char ch:w.toCharArray()){
                int index=ch-'a';
                sum=(sum+weights[index])%26;
                
            }

            char x=(char)('z'-sum);

            sb.append(x);
            
        }

        return sb.toString();
        
    }
}