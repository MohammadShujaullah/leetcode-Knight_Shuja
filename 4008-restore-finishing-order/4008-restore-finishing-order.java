import java.util.ArrayList;
class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> friendset = new HashSet<>();
        for (int f : friends) {
            friendset.add(f);

        }
       int result[]=new int[friends.length];

          int i=0;
        for (int id : order) {
            if (friendset.contains(id)) {
                result[i]=id;
                i++;

            }
        }

      

        return result;

       

    }
}