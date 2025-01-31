class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // this is given that the Array is sorted in accending order 
        // and we have to find the sum , so this  question can be solve by using  binary search

        int left=0;

        int right=numbers.length-1;

        while(left<right){
            int total= numbers[left]+numbers[right];
            if(total==target){
                return new int[]{left+1,right+1};
            }

            else if(total>target){
                right--;

            }
            else{
                left++;
            }
        }
       
       // after loop ended but ,answer is not returned then, return   
       return new int[]{-1,-1};

    }
}