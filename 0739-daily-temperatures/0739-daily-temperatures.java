
class Solution {

    // as seems the question in first go , it seem to be as NGR, usung stack, only thing is to store the index of the 

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int arr[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();

            }

            arr[i] = st.isEmpty() ? 0 : (st.peek() - i);

            st.push(i);
        }

        return arr;
    }
}