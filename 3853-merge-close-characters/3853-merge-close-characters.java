class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        boolean merged=true;

        while(merged){
            merged=false;

            for(int i=0;i<sb.length();i++){
                for(int j=i+1;j<sb.length();j++){
                    if(sb.charAt(i)==sb.charAt(j) &&(j-i)<=k){
                        sb.deleteCharAt(j);
                        merged=true;
                        break;
                    }

                    if(j-i>k) break;
                }

                if(merged) break;
            }
        }

        return sb.toString();
        
        
    }
}