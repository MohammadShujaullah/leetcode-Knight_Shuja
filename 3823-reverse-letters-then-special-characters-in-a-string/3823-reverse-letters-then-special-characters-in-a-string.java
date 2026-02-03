class Solution {
    public String reverseByType(String s) {
        List<Character>l=new ArrayList<>();
                List<Character>spe=new ArrayList<>();

        for(char ch:s.toCharArray()){
            if(ch>= 'a' && ch<= 'z'){
                l.add(ch);
                
            }else{
                spe.add(ch);
                
            }
        }

        Collections.reverse(l);
                Collections.reverse(spe);


        StringBuilder result=new StringBuilder();
        int m=0;int sl=0;
        for(char ch:s.toCharArray()){
            if(ch>= 'a' && ch<= 'z'){
                result.append(l.get(m++));
                
            }else{
                result.append(spe.get(sl++));
                
            }
        }

        return result.toString();
        


    }
}