class Solution {
    // int n;
    // HashSet<Integer> set;

    // private void Subset(int idx, int[] arr, int curror) {
    //     if (idx >= n) {
    //         return;
    //     }
    //     set.add(curror);
    //      Subset(idx + 1, arr, curror | arr[idx]);
    //      Subset(idx + 1, arr, curror);

    //     return;
    // }

    // public int subarrayBitwiseORs(int[] arr) {
    //     n = arr.length;
    //     set = new HashSet<>();
    //     int curror = 0;

    //     Subset(0, arr, curror);

    //     return set.size();

    // }
    //----------by mistake i find the distinct or of all subsets , not subarray --------------------//

    // public int subarrayBitwiseORs(int[] arr) {
    //     HashSet<Integer> set = new HashSet<>();

    //     for (int i = 0; i < arr.length; i++) {
    //         int curror = 0;
    //         for (int j = i; j < arr.length; j++) {
    //             curror |= arr[j];  // OR from i to j
    //             set.add(curror);
    //         }
    //     }

    //     return set.size();
    // }

    //--------------------------brute force-------tle------------------//

    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> curr = new HashSet<>(); // baar baar redefine hota rhegaa
            curr.add(arr[i]); // phle akela element usko add kr dia 
            for (int x : prev) { // uska or lia sabke saath jo previous han
                curr.add(x | arr[i]);
            }

            prev = curr;
            result.addAll(curr);
        }
return result.size();
    }

}