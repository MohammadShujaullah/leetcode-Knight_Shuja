class Solution {
    public List<String> removeSubfolders(String[] folder) {

        List<String> result = new ArrayList<>();

        // just sort the folder , so that first we can easily find sub folder in it 

        Arrays.sort(folder);

        // first String must not be the subfolder of any ,so add it in result 
        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String curr = folder[i];
            String lastString = result.get(result.size() - 1) + '/';
            // now find the last one in current one

            if (!curr.startsWith(lastString)) {
                result.add(curr);
            }
        }

        return result;

    }
}