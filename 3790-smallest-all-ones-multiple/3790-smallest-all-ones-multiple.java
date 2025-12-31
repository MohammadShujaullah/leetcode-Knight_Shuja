class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0 || k%5==0){
            return -1;
        }

        int reminder=0;

        for(int length=1;length<=k;length++){
            reminder=(reminder*10+1)%k;
            if(reminder==0){
                return length;
            }
        }

        return -1;
    }
   
}