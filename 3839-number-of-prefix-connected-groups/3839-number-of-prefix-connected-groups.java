class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String,Integer>pc=new HashMap<>();


        for(String w:words){
            if(w.length()>=k){
                String pref=w.substring(0,k);

                pc.put(pref,pc.getOrDefault(pref,0)+1);
                
            }
        }

        int validg=0;

        for(int count:pc.values()){
            if(count>=2){
                validg++;
                
            }
        }

        return validg;
    }
}