class Solution {

    // 2 important thingsa in this problem is, 1. is the no. will go very large as binary no. goes larger, so take modulo 5, every time , means only store the remainer is enogh, not the full no. 
    // as the remainer will be only 0,1,2,3,4
    // 2. we just have to shift the number , and add the next no. , or just multiply by 2 and add the next number

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean>res=new ArrayList<>();

        long x=nums[0];

        for(int i=0;i<nums.length;i++){

            if(i>0){
                x= (x*2+nums[i])%5;

                

            }
            if(x==0){
                res.add(true);

            }else{
                res.add(false);
            }
            
 
        }


        return res;
    }
}