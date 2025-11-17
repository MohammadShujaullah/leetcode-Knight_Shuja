class Solution {

    

    public int bagOfTokensScore(int[] tokens, int power) {
 

        Arrays.sort(tokens);    // for taking the element order wise



        int score=0;

        int maxscore=0;
        int i=0;
        int j=tokens.length-1;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i]; // sbse chota wala minus krna hoga 
                score+=1;
                maxscore=Math.max(maxscore,score);

                i++;
            }

            else if(score>=1){
                power+=tokens[j];              // sbse bda wala add krna hoga 

                score--;
                j--;

            }

            else{
                return maxscore;
            }
        }



        return maxscore;

       

    }
}