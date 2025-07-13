class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // int count=0;
        // int max=Integer.MIN_VALUE;
        // boolean help[]=new boolean[trainers.length];
        // Arrays.fill(help,false);

        // for(int i=0;i<players.length;i++){
        //     for(int j=0;j<trainers.length;j++){
        //         if(players[i]<=trainers[j] && !help[j]){
        //             help[j]=true;
        //             count++;
        //             break;
        //         }
        //     }
        //     max=Math.max(max,count);
        // }

        // return max;

        // int count=0;
        // int max=Integer.MIN_VALUE;
        // Arrays.sort(players);
        // PriorityQueue<Integer>pq=new PriorityQueue<>();
        // for(int i=0;i<trainers.length;i++){
        //     pq.add(trainers[i]);
        // }
        // boolean help[]=new boolean[ players.length];
        //  Arrays.fill(help,false);

        // for(int i=0;i<players.length;i++){

        //     while(!pq.isEmpty()){
        //         if(players[i]<=pq.peek() ){
        //           count++;

        //            pq.remove();
        //           break;

        //         }

        //     }

        // }

        // return count;
        int count = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
                j++;

            }
           else{
             j++;
           }
        }
        return count;

    }
}