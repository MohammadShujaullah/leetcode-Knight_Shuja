class Solution {

    public int maxProfit(int[] prices) {
       int maxprice=0;
       int currprice=0;
       
       int smallest=Integer.MAX_VALUE;
       for(int price:prices){
            if(price<smallest){
                smallest=price;
            }

            currprice=price-smallest;

            maxprice=Math.max(currprice,maxprice);
       }

       return maxprice;
    }
}