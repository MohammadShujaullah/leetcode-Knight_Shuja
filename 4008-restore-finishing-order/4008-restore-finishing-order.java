import java.util.ArrayList;
class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> friendset = new HashSet<>();
        for (int f : friends) {
            friendset.add(f);

        }
        List<Integer> result = new ArrayList<>();

        for (int id : order) {
            if (friendset.contains(id)) {
                result.add(id);

            }
        }

        int ans[]=new int [result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);

        }

        return ans;

       

    }
}