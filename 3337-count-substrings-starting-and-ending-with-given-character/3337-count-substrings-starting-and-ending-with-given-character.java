//bery easy problem ,based on just a loop ,with count 
//method2 , youcan do this  return (nC2+n)

class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        long subStrings = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {

                subStrings += (1+count);
                count++;

            }
        }
        return subStrings;

    }
}