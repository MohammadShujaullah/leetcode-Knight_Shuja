class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else if (j >=1 && i >=1) {
                    int num = ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1);
                    row.add(num);
                }
            }
            ans.add(row);
        }

        return ans;

    }
}
