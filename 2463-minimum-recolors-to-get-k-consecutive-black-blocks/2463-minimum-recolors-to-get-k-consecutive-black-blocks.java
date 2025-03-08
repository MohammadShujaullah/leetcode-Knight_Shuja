class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        
      
        int mincount=Integer.MAX_VALUE;     

        for(int i=0;i<=n-k;i++){             /// window size is alsways is n-k
            int whitecnt=0;
            for(int j=i;j<i+k;j++){            /// traversal in sliding window is i to less than i+k
              if(blocks.charAt(j)=='W'){
                whitecnt++;
              }

            }
            mincount=Math.min(mincount,whitecnt);

        }
        return mincount;
    }
}