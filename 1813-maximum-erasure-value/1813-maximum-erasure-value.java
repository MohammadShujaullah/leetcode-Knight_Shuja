class Solution {
    public int maximumUniqueSubarray(int[] nums) {
      

        // int windowstart=0;
        // int windowend=0;                         // varible length sliding window apply here 
        // int maxsum=Integer.MIN_VALUE;
        // HashMap<Integer,Integer>mp=new HashMap<>();

        // while(windowend<nums.length){
        //     int n=nums[windowend]; 
        //     int currsum=0;

        //     if(mp.containsKey(n) && mp.get(n)>=windowstart){
        //         windowstart=mp.get(n)+1;
        //     }

        //     mp.put(n,windowend);
        //    for(int i=windowstart;i<=windowend;i++){
        //     currsum+=nums[i];
        //    }


        //     maxsum=Math.max(maxsum,currsum);
        //     windowend++;
        // }

        //  return maxsum==Integer.MIN_VALUE?0:maxsum;

         //---------------------above solution beats 5.30%----729ms---O(n^2)----------------------//


    HashSet<Integer>st=new HashSet<>();

        int i=0;
        int j=0;
        int sum=0;
        int result=0;
        while(j<nums.length){
            if(!st.contains(nums[j])){
                sum+=nums[j];
                result=Math.max(result,sum);
                st.add(nums[j]);
                j++;

            }
            else{ /// we have to shrink the window now , untill when duplicate is seen
                while(i<nums.length && st.contains(nums[j])){
                    sum-=nums[i];
                    st.remove(nums[i]);
                    i++;

                }
            }
        }

        return result;


      
    }
}