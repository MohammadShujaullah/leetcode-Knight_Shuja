class Solution {

    // public int[] minBitwiseArray(List<Integer> nums) {

    //     int ans[] = new int[nums.size()];

    //     for (int i = 0; i < nums.size(); i++) {

    //         int x = 1;
    //         int smallest = Integer.MAX_VALUE;

    //         while (x <= nums.get(i)) {
    //             if ((x | (x + 1)) == nums.get(i)) {

    //                 smallest = Math.min(smallest, x);

    //                 ans[i] = smallest;

    //             }
    //             x++;

    //         }

    //         if (ans[i] == 0) {
    //             ans[i] = -1;

    //         }

    //     }

    //     return ans;
    // }

    // by observation, we see that if the element is even then , then their
    // is no (x|x+1), becuase x and x+1 are consucutive  and it always set the LSB to 1
    // , means no even no.,(even no. has only zeros at its LSB), so only odd numbers has (x|x+1)

    // take random x and x+1, and you can see, some observation  that , y which is x|x+1  is , x as  you just to have to change the , y by when you convert the 1st zero from LSB , convert the just one before element to 1 and convert the 

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int num=nums.get(i);
            if(num==2){
                ans[i]=-1;
                continue;
            }

            // otherwise we have to go from right to left, to the num, and find the first unset bit ,so for this, their is a method of doing this,do this:

            for(int j=1;j<32;j++){   // int goes upto 32 bit
              if((num & (1<<j))!=0){     // these are set bit, so skip
              continue;

              }

              // but if it is not a set bit ,   here we use a method(in which if i take the XOR of num with 1left shift of the (j-1), then it only change the that set bit to unset), so that num becomes ans[i]
              ans[i]=(num^(1<<(j-1)));
              break;


            }

        }

        return ans;
    }
}