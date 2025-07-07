class Solution {
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // sort according to first element , of each array

        int n = events.length;
        int count = 0; // rsult store

        int day = events[0][0];

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // min heap to , sort the end of the day , when start become equal for events

        int i = 0;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] == day) { // adding same start element to pq, to sort according to their end 

                pq.add(events[i][1]);

                i++;
            }

            if (!pq.isEmpty()) {
                pq.remove(); // attend the event on this day

                count++; // count the event 

            }

            day++;

            // skip those events whose end day  is less than the current day 

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.remove();

            }
        }

        return count;

    }
}