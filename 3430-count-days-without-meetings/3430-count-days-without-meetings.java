class Solution {
    public int countDays(int days, int[][] meetings) {
        
        // when you see the intervals in a question , firstly do sorting in it 

        Arrays.sort(meetings,(a,b)-> Integer.compare(a[0],b[0]));

        int result=0;
        int first=0;
        int end=0;

        for(int i=0;i<meetings.length;i++){
            if(meetings[i][0]>end){
                result+=meetings[i][0]-end-1;

            }
            end=Math.max(end,meetings[i][1]);

        }

        if(end<days){
            result+=days-end;

        }

        return result;
    }
}