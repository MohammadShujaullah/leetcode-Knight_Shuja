class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for (int i : arr) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);

        } // store the frequency of all elemnt
        int maxno = 0;
        int currno = 0;

        for (Map.Entry<Integer,Integer> entry : mp.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                currno = entry.getKey();

            }
            maxno = Math.max(currno, maxno);

        }
        if (currno == 0)
            return -1;
        return maxno;

    }
}