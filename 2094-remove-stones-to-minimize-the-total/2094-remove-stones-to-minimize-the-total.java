import java.util.*;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        // firslty we define the max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // sum is to store the sum of elemnet of priorityn queue
        int sum = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            pq.add(piles[i]);
            sum += piles[i]; // 18 for ex:1

        }

        for (int i = 0; i <k; i++) {
            int max = pq.peek();
            int remove= pq.remove()/2;
            max-=remove;
            sum -= remove;
              pq.add(max);
        }

        return sum;

    }
}