class Solution {
    public int getLeastFrequentDigit(int n) {
        int freq[]=new int [10];
        while(n>0){
            int digit=n%10;
            freq[digit]++;
            n/=10;

        }

        int minfreq=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<=9;i++){
            if(freq[i]>0){
                if(freq[i]<minfreq){
                    minfreq=freq[i];
                    ans=i;

                }
                else if(freq[i]==minfreq && i<ans){
                    ans=i;
                }
            }
        }

        return ans;



        // HashMap<Integer, Integer> mp = new HashMap<>();
        // while (n > 0) {
        //     int digit = n % 10;
        //     mp.put(digit, mp.getOrDefault(digit, 0) + 1);
        //     n /= 10;

        // }

        // int small = Integer.MAX_VALUE;
        // int elemt=0;
        // for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
        //     int x = entry.getKey();
        //     int y = entry.getValue();

        //     if(y<small){
        //         small=y;
        //         elemt=x;
        //     }

        //     if(small==y && elemt>x){
        //         elemt=x;
        //     }

        // }

        // return elemt;
    }
}