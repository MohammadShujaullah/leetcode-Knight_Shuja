class Solution {
    private int findsumofdigits(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n = n / 10;

        }
        return sum;

    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        int maxsize = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = findsumofdigits(i);
            mp.put(sum,mp.getOrDefault(sum,0)+1);
            if(mp.get(sum)==maxsize){
                count++;
            }
            else if(mp.get(sum)>maxsize){
                maxsize=mp.get(sum);
                count=1;

            }



        }
        return count;

    }
}