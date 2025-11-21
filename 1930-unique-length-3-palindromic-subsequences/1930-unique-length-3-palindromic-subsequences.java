class Solution {
    // har element ka first idx and last idx nikaalna ha, fir uske biich main jitne bhi element arhe honge utna hi palindrome bnegaa

    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int result=0;
        Set<Character>st=new HashSet<>();

        for(int i=0;i<n;i++){
            st.add(s.charAt(i));
        }

        for(char m:st){                 /// set main all unique element so  O(26)
            int first_idx=-1;
            int last_idx=-1;

             
            for(int i=0;i<n;i++){

                if(m==s.charAt(i)){
                    if(first_idx==-1){
                       first_idx=i;
                    }

                    last_idx=i;           // jab jab wo char milega last idx change hota rhega, till last 

                }

                  
            }
            Set<Character>ss=new HashSet<>();

            for(int j=first_idx+1;j<last_idx;j++){
                ss.add(s.charAt(j));
            }
            result+=ss.size();

            


        }

        return result;
        
        
    }
}