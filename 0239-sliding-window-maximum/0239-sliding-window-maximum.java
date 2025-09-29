
/* *** steps-->
1.when new element comes nums[i],make space for it (window size cant be greater than k)
2.now, nums[i] comes ,there is no need to keep small element in that window ,pop them 
3. now push i in deque  for num[i]
4.if(i>=k-1) ,then deque front() is our answer for that window
 */

// this also known as monotonic increasing /decreasing 
// time complexity is o(n),as we only move one time on every eleemnt ,for push and pop

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>(); // we store the index of the lement 

        int res[] = new int[n - k + 1]; //size is no. of windows

        for (int i = 0; i < n; i++) {

            // remove the element wehic is not in the window
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.remove();

            }

            //now remove the element which is smaller than , current element form last of deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();

            }
            dq.add(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peek()];
            }

        }

        return res;

    }
}