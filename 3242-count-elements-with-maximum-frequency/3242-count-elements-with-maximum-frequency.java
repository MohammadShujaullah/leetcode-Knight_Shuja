class Solution {
    // public int maxFrequencyElements(int[] nums) {
    //     HashMap<Integer,Integer>mp=new HashMap<>();

    //     for(int i=0;i<nums.length;i++){
    //         mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

    //     }
    //     int max=0;

    //     for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
    //         int key=entry.getKey();
    //         int value=entry.getValue();

    //         if(value>max){
    //             max=value;

    //         }
    //     }
    //     int count=0;

    //     for(int x:mp.keySet()){
    //         if(mp.get(x)==max){
    //             count+=max;
    //         }
    //     }

    //     return count;



    





    // }
    ///////O(2n) time complexity




// for O(n) time
     public int maxFrequencyElements(int[] nums){
        int freq[]=new int[101];

        int maxfreq=0;
        int total=0;


        for(int num:nums){
            freq[num]++;

            if(maxfreq<freq[num]){
                maxfreq=freq[num];
                total=maxfreq;
            }
            else if(maxfreq==freq[num]){
                total+=maxfreq;
            }

        }

        return total;
     }
}