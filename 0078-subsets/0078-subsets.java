// how to find the number of subset--     2^n
// how to find the the number of suvsequence -   2^n
// how to find the number of subarray --     n(n+1)/2

//if any question gives,option number ko lia  or nahi lia, then it must be recurrsion problem

//tree diagram 
// system stack=O(n)
// time co0mplexity=O(2^n), every element have two option , usko lu , yanahi lu , 
// n element , ko lu ya nahi lu ==O(2^n) 
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void solve(int[] nums, int i, List<Integer> temp) {

        if (i >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;

        }
        temp.add(nums[i]);  // taking the number 
        solve(nums, i + 1, temp);// trust on recusion
        temp.remove(temp.size() - 1);  // not taking the number 
        solve(nums, i + 1, temp);// trust on recursion

    }

    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        solve(nums, 0, temp);
        return result;

    }
}