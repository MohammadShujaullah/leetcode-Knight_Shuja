class Solution {

    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     int n = nums2.length;

    //     Map<Integer,Integer> mp = new HashMap<>();

    //     int ans[] = new int[nums1.length];

    //     for (int i = n - 1; i >= 0; i--) {
    //         if (pq.size() == 0) {
    //             mp.put(nums2[i], -1);

    //             pq.add(nums2[i]);
    //             continue;
    //         }
    //         if (nums2[i] > pq.peek()) {
    //             while (pq.size() > 0 && nums2[i] > pq.peek()) {
    //                 pq.poll();
    //             }

    //         }

    //         mp.put(nums2[i], (pq.size() != 0 ? pq.peek() : -1));
    //         pq.add(nums2[i]);
    //     }

    //     for (int i = 0; i < nums1.length; i++) {
    //         if (mp.containsKey(nums1[i])) {
    //             ans[i] = mp.get(nums1[i]);
    //         }
    //     }

    //     return ans;
    // }

    /////////////////--------above solution is uses PriorityQ+hashMap--------//////
    ////////////----------but best solution is using Monotonic stack +HashMap------///

    //// map ke andr search krna is very easy, O(1), so we use map

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Stack<Integer>st=new Stack<>();

        int n = nums2.length;

        Map<Integer,Integer> mp = new HashMap<>();

        int ans[] = new int[nums1.length];

        for (int i = n - 1; i >= 0; i--) {
           
           
                while (st.size() > 0 && nums2[i] > st.peek()) {
                    st.pop();
                }

            
             if (st.size() == 0) {
                mp.put(nums2[i], -1);

              
            }
            else{
            mp.put(nums2[i], (st.size() != 0 ? st.peek() : -1));

            }

            st.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (mp.containsKey(nums1[i])) {
                ans[i] = mp.get(nums1[i]);
            }
        }

        return ans;
    }

}