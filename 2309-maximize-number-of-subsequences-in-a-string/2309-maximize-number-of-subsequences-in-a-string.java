class Solution {

    //we have to return the answer max ans between ,either adding patern0 at text, or adding patern 1 at text
    //there is an edge case when pattern's elements are equal as 'aa'    so here we use the forlmula of count*(count-1)/2

    char ch1;
    char ch2;

    private long solve(StringBuilder sb, String pattern, long ans) {

        long count = 0;
        int i=0;
        while (i < sb.length()) {
            if (pattern.charAt(0) != pattern.charAt(1)) {
                if (sb.charAt(i) == ch1) {
                    count = count + 1;
                } else if (sb.charAt(i) == ch2) {
                    ans += count;
                }

            } else {
                if (sb.charAt(i) == ch1) {
                    count = count + 1;
                    
                }
              

            }

            i++;
        }
 return (pattern.charAt(0) == pattern.charAt(1)) ? (count * (count - 1) / 2) : ans;
        

    }

    public long maximumSubsequenceCount(String text, String pattern) {
        ch1 = pattern.charAt(0);
        ch2 = pattern.charAt(1);
        StringBuilder sb1 = new StringBuilder(text);
        StringBuilder sb2 = new StringBuilder(text);

        // Insert the character at index 0 (the beginning)
        sb1.insert(0, ch1);

        sb2.append(ch2);

        long ans1 = 0;
        long ans2 = 0;
        ans1 = solve(sb1, pattern, ans1);
        ans2 = solve(sb2, pattern, ans2);

        return   Math.max(ans1, ans2);

    }
}