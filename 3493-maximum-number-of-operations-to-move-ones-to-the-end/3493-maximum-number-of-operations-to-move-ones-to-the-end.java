class Solution {
    public int maxOperations(String s) {
        int n=s.length();

        int i=0;
        int count1=0;
        int result=0;


        while(i<n){
          if(s.charAt(i)=='1'){
            count1++;
            i++;

          }
          else{
            result+=count1;

            while(i<n && s.charAt(i)=='0'){    // continues 0 pr bhi same no. of operation
                i++;
            }
          }

          

        }

        return result;

    }
}