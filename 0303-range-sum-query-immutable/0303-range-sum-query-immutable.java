class NumArray {
    // as for every left and right , ihave to calculate the sum , so its take O(N), which is larg for the contrain
    // so we have to use frefix sum , as it is perfectly fit for this question to find the range sum 
    private int []prefix;

    public NumArray(int[] nums) {
        prefix=new int [nums.length];
        prefix[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
       
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return prefix[right];    // just by observation during dry run

        }

        return prefix[right]-prefix[left-1];
        
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */