class Solution {
    // my first own approch passes the 83/117 test cases

    // private void fill(int x[], HashSet<Integer> st) {
    //     int count = 2;
    //     for (int i = x[0]; i <= x[x.length - 1]; i++) {
    //         if (st.contains(i) && count > 0) {
    //             count--;
    //         }
    //     }

    //     if (count == 2) {
    //         st.add(x[x.length - 2]);
    //         st.add(x[x.length - 1]);
    //     }
    //     if (count == 1 && !st.contains(x[x.length - 1])) {
    //         st.add(x[x.length - 1]);

    //     }  

    // }

    // public int intersectionSizeTwo(int[][] intervals) {
    //     HashSet<Integer> st = new HashSet<>();
    //     Arrays.sort(intervals, (a, b) -> Integer.compare(a[a.length - 1], b[b.length - 1]));
    //     for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
    //         if (i == intervals[0][1] || i == intervals[0][1] - 1) {
    //             st.add(i);
    //         }

    //     }

    //     for (int[] x : intervals) {
    //         fill(x, st);

    //     }

    //     return st.size();
    // }

    public int intersectionSizeTwo(int[][] intervals) {

        Arrays.sort(intervals,
                (a, b) -> {
                    if (a[1] != b[1]) {
                        return a[1] - b[1];
                    }
                    return b[0] - a[0];
                });

        int first = -1;
        int second = -1;
        int count = 0;

        for (int x = 0; x < intervals.length; x++) {
            int l = intervals[x][0];
            int r = intervals[x][1];

            if (l <= first) {
                continue;
            }

            if (l <= second) {
                //we have to take only one point  i.e. last point r
                first = second;
                second = r;

                count += 1;

            } else {
                // no point lies inside the left and right
                count += 2;
                second = r;
                first = r - 1;

            }

        }

        return count;

    }
}