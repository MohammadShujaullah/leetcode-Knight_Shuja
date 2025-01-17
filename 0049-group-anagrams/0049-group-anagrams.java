class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>result= new ArrayList<>();

        int n=strs.length;
        HashMap<String,List<String>>mp= new HashMap<>();

        for(String str:strs){
            char[]sortarr= str.toCharArray();   //
            Arrays.sort(sortarr);               // these 3 lines to sort the string
            String sortstr=new String(sortarr); //



            if(!mp.containsKey(sortstr)){
                mp.put(sortstr,new ArrayList<>());

            }
            // else
            mp.get(sortstr).add(str);

        }
        return new ArrayList<>(mp.values());

    }
}