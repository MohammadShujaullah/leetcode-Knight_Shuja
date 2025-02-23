class Solution {
    public int lengthOfLongestSubstring(String s) {
        //using hashset 
        int windowstart=0;
        int windowend=0;
        int n=s.length();
        int maxlen= Integer.MIN_VALUE;
        // HashSet<Character>set = new HashSet<>();
        HashMap<Character,Integer>mp= new HashMap<>();

        while(windowend<n){
            char ch = s.charAt(windowend);
            if(mp.containsKey(ch) && mp.get(ch)>=windowstart){
                //shrinking 
                // while(windowstart<windowend && set.contains(ch)){
                //     set.remove(s.charAt(windowstart));
                //     windowstart++;
                windowstart=mp.get(ch)+1;

                }
            
            mp.put(ch,windowend);


           // set.add(ch);   // expanding 
            maxlen= Math.max(maxlen,windowend-windowstart+1);
            windowend++;


        }
        return (maxlen==Integer.MIN_VALUE)?0:maxlen;


    }
}