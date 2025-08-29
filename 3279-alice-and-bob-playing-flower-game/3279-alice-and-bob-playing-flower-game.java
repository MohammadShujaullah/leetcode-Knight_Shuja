class Solution {

    // alice always wins when the total sum of the x and y is odd

    // and when will we get sum odd, only when either x is odd or y is even ,
    // either y is odd and x is even  

   //** * number of odd element in in (1,n)=  n+1/2
   //** * number of odd element in in (1,n)=  n/2

   // so the answer is the combination of (x even +y odd +  x odd+y even )


    public long flowerGame(int n, int m) {
        
      
   
        // Step 1: Count odds and evens in range [1, n]
        long oddX = (n + 1) / 2;
        long evenX = n / 2;

        // Step 2: Count odds and evens in range [1, m]
        long oddY = (m + 1) / 2;
        long evenY = m / 2;

        // Step 3: Alice wins when x+y is odd
        // Case 1: x odd & y even
        // Case 2: x even & y odd

        // Step 4: Count total winning pairs
        return oddX * evenY + evenX * oddY;
    }
 
}