class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums2.length;

        Map<Integer,Integer> mp = new HashMap<>();

        int ans[] = new int[nums1.length];

        for (int i = n - 1; i >= 0; i--) {
            if (pq.size() == 0) {
                mp.put(nums2[i], -1);

                pq.add(nums2[i]);
                continue;
            }
            if (nums2[i] > pq.peek()) {
                while (pq.size() > 0 && nums2[i] > pq.peek()) {
                    pq.poll();
                }

            }

            mp.put(nums2[i], (pq.size() != 0 ? pq.peek() : -1));
            pq.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (mp.containsKey(nums1[i])) {
                ans[i] = mp.get(nums1[i]);
            }
        }

        return ans;
    }
}