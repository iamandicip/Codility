package train.smallestelement;

import java.util.*;

public class Solution {

  /*
   * 
   * This is a demo task.
   * 
   * Write a function:
   * 
   * class Solution { public int solution(int[] A); }
   * 
   * that, given an array A of N integers, returns the smallest positive integer
   * (greater than 0) that does not occur in A.
   * 
   * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
   * 
   * Given A = [1, 2, 3], the function should return 4.
   * 
   * Given A = [−1, −3], the function should return 1.
   * 
   * Write an efficient algorithm for the following assumptions:
   * 
   * N is an integer within the range [1..100,000]; each element of array A is an
   * integer within the range [−1,000,000..1,000,000].
   * 
   */

  public int solution(int[] A) {
    int missing = 1;

    Arrays.sort(A); // O(n * log(n))

    for(int i = 0; i < A.length; i++) {  // O(n)
      if(A[i] > 0 && A[i] == missing) {
        missing++;
      } 
    }

    return missing;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[] {1, 3, 6, 4, 1, 2}));
    System.out.println(solution.solution(new int[] {1, 3, 2}));
    System.out.println(solution.solution(new int[] {-99999999, 999999999}));
    System.out.println(solution.solution(new int[] {-99999999, 1, 2, 4, 999999999}));
    System.out.println(solution.solution(new int[] {0, 0}));
    System.out.println(solution.solution(new int[] {10000}));
  }

}
