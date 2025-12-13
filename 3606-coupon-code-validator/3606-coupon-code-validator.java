import java.util.*;
class Pair {
   
    int x;
     String s1;

    public Pair( int x,String s1) {
        this.x = x;
        this.s1 = s1;
        

    }
}

class Solution {

    private boolean isValid(String s) {

        if(s.isEmpty() || s==null){
            return false;
        }
      for(char ch:s.toCharArray()){
         if(!Character.isLetterOrDigit(ch) && ch!='_'){
            return false;
         }
      }

        return true;

    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("electronics", 0);
        mp.put("grocery", 1);
        mp.put("pharmacy", 2);
        mp.put("restaurant", 3);

         
        List<Pair> temp = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]
                    && mp.containsKey(businessLine[i])
                    && isValid(code[i])) {

                temp.add(new Pair(mp.get(businessLine[i]), code[i]));
            }
        }

Collections.sort(
    temp,
    Comparator.comparingInt((Pair p) -> p.x)
              .thenComparing(p -> p.s1)
);

        List<String> result = new ArrayList<>();
        for (Pair p : temp) {
            result.add(p.s1);
        }

        return result;
    }
}