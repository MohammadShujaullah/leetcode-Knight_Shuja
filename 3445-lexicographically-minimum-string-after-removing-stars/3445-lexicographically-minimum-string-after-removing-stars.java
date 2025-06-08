class p {
    char c;
    int i;

    public p(char c, int i) {
        this.c = c;
        this.i = i;
    }
}

class Solution {
    public String clearStars(String s) {

        char[] str = s.toCharArray();

        Queue<p> pq = new PriorityQueue<>((a, b) -> {
            if (a.c == b.c) { // if the charecters arw same 
                return b.i - a.i;

            }

            return Character.compare(a.c, b.c); // if charater are diffrent 
        });

        for (int i = 0; i < str.length; i++) {

            char c = str[i];

            if (c != '*') {
                pq.add(new p(c, i));
                continue;
            }

            // and iff * is present , then remove the top of queue if not empty

            if (!pq.isEmpty()) {
                p P = pq.poll();
                str[P.i] = '*';

            }

        }
        char[] result = new char[str.length];

        int index = 0;
        for (char c : str) {
            if (c != '*') {
                result[index++] = c;

            }

        }

        return new String(result, 0, index);
    }
}