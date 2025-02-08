class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        int n = groupSizes.length;

        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if (!mp.containsKey(groupSizes[i])) {
                mp.put(groupSizes[i], new ArrayList<>());

            }

            mp.get(groupSizes[i]).add(i); /// instead of using count we use--> mp.get(groupSizes[i]).size()

            // If the group is complete, move it to result and clear the list
            if (mp.get(groupSizes[i]).size() == groupSizes[i]) {

                result.add(new ArrayList<>(mp.get(groupSizes[i]))); // important step** for me
                mp.get(groupSizes[i]).clear();

            }

        }

        return result;

    }
}