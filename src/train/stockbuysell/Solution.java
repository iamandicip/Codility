package train.stockbuysell;

public class Solution {

  /*
   * You are given an array prices where prices[i] is the price of a given stock
   * on the ith day.
   * 
   * Find the maximum profit you can achieve. You may complete as many
   * transactions as you like (i.e., buy one and sell one share of the stock
   * multiple times).
   * 
   * Note: You may not engage in multiple transactions simultaneously (i.e., you
   * must sell the stock before you buy again).
   */

  public int maxProfit(int[] prices) {
    int maxprofit = 0;
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1])
            maxprofit += prices[i] - prices[i - 1];
    }
    return maxprofit;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    System.out.println(solution.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
    System.out.println(solution.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
  }
}
