class Solution {
    // Brute force solution giving me the TLE 

    // public int brokenCalc(int startValue, int target) {
    //     int count=0;

    //     int i=target;

    //     while(target!=startValue){

    //         target/=2;
    //         count+=1;
    //         if(target==startValue){
    //            break;
    //         }
    //         target+=1;
    //         count+=1;
    //           if(target==startValue){
    //            break;
    //         }

    //     }

    //     return count;
    // }

    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while (target != startValue) {
            if (target % 2 == 0 && target > startValue) {
                target /= 2;
                res += 1;
            } else if (target % 2 != 0) {
                target += 1;
                res += 1;
            } else if (target < startValue) {
                target += 1;
                res += 1;
            }
        }

        return res;

    }
}