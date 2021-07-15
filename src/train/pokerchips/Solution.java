package train.pokerchips;

public class Solution {
  /*
   * Luigy works in a Casino and he gives customers poker chips in exchange for
   * money. Find the minimum number of chips Luigy can use to match the customer
   * requests. He has chips worth 1OO, 5O, 25, 1O, 5, 1. 
   * For example, for 126, Luigy should give 3 chips (1OO, 25, 1).
   */

  public int calculateMinTokens(int[] chips, int amount) {
    int amt = amount, tokens = 0;
    for (int chip : chips) {
      if (amt >= chip) {
        int mod = amt % chip, div = amt / chip;

        tokens += div;

        if (mod > 0) {
          amt = mod;
        }
      }
    }
    return tokens;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] chips = new int[] { 100, 50, 25, 10, 5, 1 };
    System.out.println(solution.calculateMinTokens(chips, 89));
    System.out.println(solution.calculateMinTokens(chips, 647));
    System.out.println(solution.calculateMinTokens(chips, 126));
  }
}
