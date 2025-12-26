class Solution {

    // BRUTE FORCE APPROCH------------------------------------
    // public int bestClosingTime(String customers) {
    //     int min = Integer.MAX_VALUE;
    //     int idx=0;

    //     for (int i = 0; i <= customers.length(); i++) {
    //         int count = 0;

    //         for (int j = 0; j < customers.length(); j++) {

    //             if (customers.charAt(j) == 'Y' && j < i) {
    //                 continue;
    //             } else if (customers.charAt(j) == 'Y') {
    //                 count++;

    //             }else if (customers.charAt(j) == 'N' && j<i) {
    //                 count++;

    //             }

    //         }

    //             if(min>count){
    //                 min=count;
    //                 idx=i;
    //             }

    //     }

    //     return idx;
    // }---------------------------------------------------------TLE 33/42 TEST CASES

    public int bestClosingTime(String customers) {
        // for suffix of Y , we can use variable , no need of array,   store the total Y at intial

        // and for prefix of N we can use , just use varible for it , how many N you see so far

        int penality = 0;
        
        int idx = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                penality++;
            }
        }
        int minpenality =penality;

        for (int i = 0; i <customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penality--;

            } else {
                penality++;
            }

            if (minpenality > penality) {
                minpenality = penality;
                idx = i + 1;
            }

        }

        return idx;
    }

}