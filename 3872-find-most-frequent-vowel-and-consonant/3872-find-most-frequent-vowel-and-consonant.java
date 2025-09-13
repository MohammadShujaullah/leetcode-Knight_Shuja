class Solution {
    private boolean isVowel(char ch) {
        char m = Character.toLowerCase(ch);
        if (m == 'a' || m == 'e' || m == 'i' || m == 'o' || m == 'u') {
            return true;
        }
        return false;
    }

    public int maxFreqSum(String s) {
        Map<Character,Integer>mp=new HashMap<>();

        for(int i=0;i<s.length();i++){
             
                mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);

            
        }

        int maxvol=0;
        int maxcon=0;

        for(Map.Entry<Character,Integer>entry:mp.entrySet()){
            char ch=entry.getKey();
            int i=entry.getValue();
             
             if(isVowel(ch)){
              maxvol=Math.max(maxvol,i);

             }
             else{
                maxcon=Math.max(maxcon,i);
             }

        }

        return maxvol+maxcon;
    }
}