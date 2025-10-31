import java.util.*;

class Solution {// we use element as index marker technique, v.v.i technique
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>l=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int num=Math.abs(nums[i]);

            int idx=num-1;

            if(nums[idx]<0){
               l.add(num);
            }else{
                nums[idx]*=-1;
            }
        }

        return l;
         

    }
}