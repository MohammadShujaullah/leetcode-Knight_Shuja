class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> l = new ArrayList<>();

        int stream = 0;
        int m = 1;

        while (stream < target.length && m <= n) {
            l.add("Push");

            if (m == target[stream]) {
                stream++;
            } else {
                l.add("Pop");
            }

            m++;
        }

        return l;
    }
}