class Solution {
    public int characterReplacement(String s, int k) {
        //we will use frequency array to store the freq. of all char

        int freq[]=new int [26];
        int l=0;

        int maxwindow=0;
        int maxfreq=0;

       for(int r=0;r<s.length();r++){
            freq[s.charAt(r)-'A']++;

            // we have to calculate the maxfreq for every elemnt
            maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);


            maxwindow=r-l+1;  // maxwindow calculation at evry r and i

            if(maxwindow-maxfreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);
            maxwindow=r-l+1;  // maxwindow calculation at evry r and i



       }

       return maxwindow;
       

    }
}