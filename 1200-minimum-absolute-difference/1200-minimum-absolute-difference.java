class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> l = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = i + 1;

        while (i < arr.length && j < arr.length) {
            min = Math.min(min, Math.abs(arr[i] - arr[j]));
            i++;
            j++;

        }

        i = 1;

        while (i < arr.length) {
            if (Math.abs(arr[i] - arr[i - 1]) == min) {
                List<Integer> newPair = new ArrayList<>();
                newPair.add(arr[i - 1]);
                newPair.add(arr[i]);

                l.add(newPair);

            }
            i++;
        }

        return l;

    }
}