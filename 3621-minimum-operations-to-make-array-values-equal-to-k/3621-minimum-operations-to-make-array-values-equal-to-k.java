// as the number of unique element in the array, just equal to the number of opration , to change to k

// as the number must be greater than k, otherwise return -1
// now to find the unique element in the array , we can use set , we could insert the element in the
// set and all unique element now present in the set

class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> st = new HashSet<>();

        for (int x : nums) {
            if (x < k)
                return -1;

            else if (x > k) {
                st.add(x);

            }
        }

        int count = 0;
        for (int i : st) {
            count++;
        }

        return count;
    }
}