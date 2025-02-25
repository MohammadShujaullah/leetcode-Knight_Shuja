class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int i = 0, j = n - 1;

        int boats = 0;

        // first of all ,sort the peoples array to know the heviest and lightest people
        Arrays.sort(people);

        while (i <= j) {
            if (people[j] + people[i] <= limit) {
                i++;
                j--;

            } else {
                // agr heavy man mill jae, to akele hi boat main dalna hoga usko

                j--;

            }
            boats += 1;

        }

        return boats;

    }
}