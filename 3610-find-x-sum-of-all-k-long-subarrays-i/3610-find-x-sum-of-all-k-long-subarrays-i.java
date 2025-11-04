import java.util.*;
class Solution {// mean heap for max frequency
    private int solve( HashMap<Integer, Integer> mp, int x) {
PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> pq =
    new PriorityQueue<>((a,b)->
       
       a.getValue().equals(b.getValue())?a.getKey()-b.getKey():a.getValue()-b.getValue());


        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){

            int k=entry.getKey();
            int v=entry.getValue();
            

            pq.add(new AbstractMap.SimpleEntry<>(k,v));


            if(pq.size()>x){
                pq.remove();


            }

            
        }

  int sum=0;
        while(!pq.isEmpty()){
          AbstractMap.SimpleEntry<Integer,Integer>entry=pq.poll();

          sum+=(entry.getKey()*entry.getValue());

        }

        return sum;
         

    }

    public int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int ans[] = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);

        }

        ans[0] = solve(mp,x);

        // sliding the window 

        for (int i = 1; i < nums.length - k + 1; i++) {
            int j = i + k - 1;

           
           mp.put(nums[i - 1], mp.get(nums[i - 1]) - 1);
            if (mp.get(nums[i - 1]) == 0) {
                mp.remove(nums[i - 1]);

            }  

            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
             ans[i] = solve(mp, x);

        }

        return ans;

    }
}