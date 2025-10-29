class Solution {
    public int smallestNumber(int n) {
        
        String binary= Integer.toBinaryString(n);


        StringBuilder sb=new StringBuilder(binary);


        for(int i=0;i<sb.length();i++){
           if(sb.charAt(i)=='0'){
            sb.setCharAt(i,'1');

           }
             
        }

        return Integer.parseInt(sb.toString(),2);


    }
}