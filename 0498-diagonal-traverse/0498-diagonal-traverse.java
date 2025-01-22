class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // fill the map using i+j
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!mp.containsKey(i + j)) {
                    mp.put(i + j, new ArrayList<>());

                }
                mp.get(i + j).add(mat[i][j]);

            }
        }
        boolean flip = true;
        for (int key : mp.keySet()) {
            List<Integer> temp = mp.get(key);

            if (flip) {
                Collections.reverse(temp); // this this function for arraylist to reverse the arraylist

            }
            result.addAll(temp);
            flip=!flip;

        }
        int[] integerArray =result.stream().mapToInt(i->i).toArray();
        return integerArray ;

    }
}