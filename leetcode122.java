public class leetcode122 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            if(prices[i]-min>0){
                sum+=prices[i]-min;
                min=prices[i];
            }
        }
        return sum;
    }
}
