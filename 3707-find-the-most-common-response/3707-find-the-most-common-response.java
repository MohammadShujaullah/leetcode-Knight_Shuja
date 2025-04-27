class Solution {
    public String findCommonResponse(List<List<String>> responses) {
         Map<String, Integer> freqMap = new HashMap<>();
        
        for (List<String> dayResponses : responses) {
            Set<String> uniqueResponses = new HashSet<>(dayResponses);
            for (String response : uniqueResponses) {
                freqMap.put(response, freqMap.getOrDefault(response, 0) + 1);
            }
        }
        
        String result = "";
        int maxFreq = 0;
        
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            String response = entry.getKey();
            int freq = entry.getValue();
            if (freq > maxFreq || (freq == maxFreq && response.compareTo(result) < 0)) { // 2nd condition is for same frequency, then you have to return lexicographically answer
                result = response;
                maxFreq = freq;
            }
        }
        
        return result;
    }
}