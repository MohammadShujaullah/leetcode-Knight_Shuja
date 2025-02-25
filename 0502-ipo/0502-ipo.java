class Project implements Comparable<Project> {
    int profit;
    int capital;

    Project(int profit,int capital ){
        this.profit=profit;
        this.capital= capital;
    }

    // @method override
    public int compareTo(Project that) {
        // min heAP
        return this.capital-that.capital; // for accending order
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minPQ = new PriorityQueue<>();
        int n = capital.length;
        for (int i = 0; i < n; i++) {
            minPQ.add(new Project(profits[i], capital[i]));

        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        while(k>0){

            /* fill all the project whose capitsal are is less than or equal to w */
            while(!minPQ.isEmpty() && minPQ.peek().capital<=w){
                maxPQ.add(minPQ.poll().profit);
            }
             if(maxPQ.isEmpty()) break;
         w+= maxPQ.poll();
         k--;
           
        }
        return w;
        
    }

}