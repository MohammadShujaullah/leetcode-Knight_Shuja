class Solution {
    // int n;
    // long t[][];

    // private long solve(int p, int idx, int[] nums) {
    //     if (idx == n)
    //         return 0;

    //     if (t[idx][p + 1] != -1) {
    //         return t[idx][p + 1];
    //     }

    //     long takesum = Integer.MIN_VALUE;
    //     long skipsum = Integer.MIN_VALUE;
    //     if (p == -1 || ((nums[idx] - idx) >= (nums[p] - p))) {
    //         takesum = nums[idx] + solve(idx, idx + 1, nums);

    //     }
    //     skipsum = solve(p, idx + 1, nums);

    //     return t[idx][p + 1] = (long) Math.max(skipsum, takesum);

    // }

    // public long maxBalancedSubsequenceSum(int[] nums) {

    //     int max = Arrays.stream(nums).max().getAsInt(); // inbuilt method to find maximum in array
    //     if (max <= 0)
    //         return max;
    //     n = nums.length;
    //     t = new long[n + 1][n + 1];
    //     for (long row[] : t) {
    //         Arrays.fill(row, -1);
    //     }

    //     return solve(-1, 0, nums);

    // }
    //---------------------------- ABOVE recursion+memo gives TLE AND MLE ------------------------------//  


    // public long maxBalancedSubsequenceSum(int[] nums) {

    //     int maxx = Arrays.stream(nums).max().getAsInt(); // inbuilt method to find maximum in array
    //     if (maxx <= 0)
    //         return maxx;


    //     long t[] = new long[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         t[i] = nums[i];
    //     }

    //     long max = Integer.MIN_VALUE;

    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (nums[i] - i >= nums[j] - j) {
    //                 t[i] = Math.max(t[i], t[j] + nums[i]); // whan pr length nikaalne ke liye 1 add kr rhe the , yha pr hme sum nikaalna ha to nums[i] add kr rhe h
    //                 max = Math.max(t[i], max);
    //             }
    //         }
    //     }

    //     return max;

    // }

    ///------------------ above code giving TLE also , Bottom up ---------------------//
     public long maxBalancedSubsequenceSum(int[] nums){
        int n=nums.length;
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=nums[i]-i;

        }
        TreeMap<Integer,Long>mp=new TreeMap<>();
        Long ans=Long.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                ans=Math.max(ans,nums[i]);
            }
            else{
                long temp=nums[i];
                if(mp.floorKey(arr[i])!=null){
                    temp+=mp.get(mp.floorKey(arr[i]));   // i am just finding , the value in keys , which is just smaller than arr[i],
                }
                 //Find the previous arr[j] that is ≤ current arr[i] and has the best accumulated subsequence sum up to that point.


                while(mp.ceilingKey(arr[i])!=null && mp.get(mp.ceilingKey(arr[i]))<temp){  // we are just finding  and then removing those keys & values , which is just greater tham arr[i], but their sum is lesser than arr[i]
                    mp.remove(mp.ceilingKey(arr[i]));


                }
                if(mp.floorKey(arr[i])==null || mp.get(mp.floorKey(arr[i]))<temp){
                    mp.put(arr[i],temp);
                }
                 ans = Math.max(ans, temp);

            }







        }
        return ans;

     }
}