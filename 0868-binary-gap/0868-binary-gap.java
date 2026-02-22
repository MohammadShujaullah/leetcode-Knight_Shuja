class Solution {
    public int binaryGap(int n) {
        String Binary=Integer.toBinaryString(n);

        int max=0;

        for(int i=0;i<Binary.length();i++){
            for(int j=i+1;j<Binary.length();j++){
                if(Binary.charAt(i)=='1' && Binary.charAt(j)=='1'){
                   int count=j-i;

                    max=Math.max(max,count);
                    break;
                }
            }
        }

        return max;

    }
}