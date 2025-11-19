class Solution {
    // we have to carry only 2 persons at a boat and  if we carry the heviest 
    //and lightest thenits correct , and heviest is enough for one boat then ,
    // escap ehte heviest the man  

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