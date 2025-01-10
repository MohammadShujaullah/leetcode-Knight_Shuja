class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length;
        int n = people.length;
        int result[] = new int[n];

        int start_time[] = new int[m];
        int end_time[] = new int[m];

        for (int i = 0; i < m; i++) {
            start_time[i] = flowers[i][0];
            end_time[i] = flowers[i][1];

        }

        Arrays.sort(start_time);
        Arrays.sort(end_time); // doing sorting at both array

        for (int i = 0; i < n; i++) {
            int bloomed_already = binarysearchupperbond(start_time, people[i]);
            int died_already = binarysearchlowerbond(end_time, people[i]);
            result[i] = bloomed_already - died_already;

        }
        return result;

    }

    private int binarysearchupperbond(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return result == -1 ? arr.length : result;

    }

    private int binarysearchlowerbond(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;

            } else {
                result = mid;
                right = mid - 1;

            }

        }
        return result == -1 ? arr.length : result;

    }
}