class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;

        for (int x : apple) {
            sum += x;

        }
        int count = 0;
        int currsum = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            currsum += capacity[i];
             count++;
            if (currsum >= sum) {
                break;
            }
           

        }

        return count;
    }
}