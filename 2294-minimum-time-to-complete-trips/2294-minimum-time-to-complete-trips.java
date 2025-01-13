class Solution {
    // time complexity--> O(n*Log( array min value*totaltrips))
    
    private long timecalculate(int[] time, int totalTrips,Long mid) {
        long count =0 ;
        for (int i = 0; i < time.length; i++) {
            count += mid / time[i];

        }
        return count;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long l =1;
        long r =(long) Arrays.stream(time).min().getAsInt() * totalTrips;  // finding minimum element from array

        while (l < r) {
            Long mid = l + (r - l) / 2;
            Long count=timecalculate(time,totalTrips,mid);
            if(count>=totalTrips){    // taking count=totaltrips , because ,if answer is found ,
            //tab bhi apko left jakr dekhna hoga ,ke usse minimum time main kaam ho payega ya nahi 
                r=mid;
            }
            else if(count<totalTrips){
                l=mid+1;
            }
             
        }
         return l;
    }
}