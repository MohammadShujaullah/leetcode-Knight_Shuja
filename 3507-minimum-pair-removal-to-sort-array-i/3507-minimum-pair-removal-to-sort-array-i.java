class Solution {

    private int minSumidx(List<Integer> l) {
        int minsum = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < l.size() - 1; i++) {
            int sum = l.get(i) + l.get(i + 1);
            if (sum < minsum) {
                minsum = sum;
                idx = i;
            }
        }

        return idx;
    }
    private boolean isSorted( List<Integer> l ){
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>l.get(i+1)){
                return false;
            }
        }

        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> l = new ArrayList<>(); // used as variable array

        int operation=0;
        for (int n : nums) {
            l.add(n);

        }

        while (!isSorted(l)) {
            int idx = minSumidx(l);

            int merged=l.get(idx)+l.get(idx+1);

            l.set(idx,merged);

            l.remove(idx+1);
            operation++;
        }


        return operation;

    }
}