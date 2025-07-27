class Solution {
    // int n;
    // private void solve(int idx, int[] nums, List<Integer> answer, List<Integer> temp, int p) {
    //     if (idx >= n) {
    //         // jab ham puura ghoom lenge ,phir temp ko answer main add krenge
    //         if (temp.size() > answer.size()) {
    //             answer.clear();     //puraana wala answer clear krdo , and new wala temp copy krdo inside answer
    //             answer.addAll(temp);
    //         }

    //         return;

    //     }
    //       // take option 
    //     if (p == -1 || (nums[p] % nums[idx] == 0 || nums[idx] % nums[p] == 0)) {

    //         temp.add(nums[idx]);// taken 
    //         solve( idx + 1, nums, answer,temp,idx);
    //         temp.remove(temp.size()-1); // backtrack the system 
    //     }

    //     // not take     
    //     solve( idx + 1, nums, answer,temp,p);

    // }

    // public List<Integer> largestDivisibleSubset(int[] nums) {
    //     Arrays.sort(nums);

    //     List<Integer> answer = new ArrayList<Integer>();
    //     List<Integer> temp = new ArrayList<>();

    //     n = nums.length;
    //     int prev = -1;

    //     solve(0, nums, answer, temp, prev);
    //     return answer;

    // }
    //-------------------------recursion , and with memo , gives TLE -------------///

    //array where t[i] represents the length of the largest divisible
    //subset ending at index i. Dp array should initially consist of all 1's.

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int t[] = new int[nums.length];
        Arrays.fill(t, 1); // divisible by it self

        int prev_idx[] = new int[nums.length];
        Arrays.fill(prev_idx, -1);

        int maxi = 0; // store the index of lsrgest element whixh has longest subset
        int maxL = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        prev_idx[i]= j;

                    }
                    if (t[i] > maxL) {
                        maxL = t[i];
                        maxi =i;

                    }
                }
            }
        }
        List<Integer>result=new ArrayList<>();

        while(maxi!=-1){
            result.add(nums[maxi]);
            maxi=prev_idx[maxi];
        }

        return result;



    }

}