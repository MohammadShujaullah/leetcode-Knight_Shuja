class Solution {
    public String[] divideString(String s, int k, char fill) {

        StringBuilder S1 = new StringBuilder(s);

        if (S1.length() % k != 0) {
            for (int i = 0; i < (S1.length() % k); i++) {
                S1.append(fill);                   // adding the fill in the S1
            }

        }

        // now S1 is abdefghxxxx <--just for example

        String res[] = new String[S1.length()/k];

        int i = 0;
        int idx=0;
        while (i < S1.length()) {
            StringBuilder s1 = new StringBuilder();

            for (int j = i; j < k + i; j++) {
                s1.append(S1.charAt(j));

            }

            res[idx] = s1.toString();
            s1.setLength(0);
            i=i+k;
            idx++;

        }

        return res;

    }
}