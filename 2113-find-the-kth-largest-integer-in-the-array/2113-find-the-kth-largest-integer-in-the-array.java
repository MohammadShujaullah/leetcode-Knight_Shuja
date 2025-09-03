class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        // as i am converting the string into integer   and then put it in the heap, but it gives me
        // runtime , becuase number goes beyond the range of integer

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // smaller length = smaller number
            } else { // if number are of smae length, then lecicographic compare
                return a.compareTo(b);

            }
        });

        for (int i = 0; i < n; i++) {

            pq.add(nums[i]);

            if (pq.size() > k) {
                pq.remove();

            }
        }

        return String.valueOf(pq.peek());
    }
}