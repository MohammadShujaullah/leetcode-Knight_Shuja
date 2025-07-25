class Solution {

    private String removeSubstr(String s, String matchStr) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == matchStr.charAt(1) && !st.isEmpty() && st.peek() == matchStr.charAt(0)) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());

        }

        return sb.reverse().toString();

    }

    public int maximumGain(String s, int x, int y) {

        String maxstr = (x > y) ? "ab" : "ba";
        String minstr;
        if (maxstr.equals("ab")) { //This is updated after the video was made as a new test case was added in Leetcode
            minstr = "ba";
        } else {
            minstr = "ab";
        }

        int score = 0;

        //first max pass
        String temp_first = removeSubstr(s, maxstr);
        int L = temp_first.length();

        int charRemoved = (s.length() - L);

        score += (charRemoved / 2) * Math.max(x, y); //pair of removal =charmeoved/2

        //second min pass
        String temp_second = removeSubstr(temp_first, minstr);

        int L2 = temp_second.length();

        int charRemoved2 = (L - L2);

        score += (charRemoved2 / 2) * Math.min(x, y); // chsarecter ko jo aapne remove kia ha , uska pair lena ha 

        //now return score

        return score;

    }
}