package train.missingelement;

import java.util.Arrays;

public class Solution {

  /*
   * An array A consisting of N different integers is given. The array contains
   * integers in the range [1..(N + 1)], which means that exactly one element is
   * missing.
   * 
   * Your goal is to find that missing element.
   * 
   * Write a function:
   * 
   * class Solution { public int solution(int[] A); }
   * 
   * that, given an array A, returns the value of the missing element.
   * 
   * For example, given array A such that: A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5
   * 
   * the function should return 4, as it is the missing element.
   * 
   * Write an efficient algorithm for the following assumptions:
   * 
   * N is an integer within the range [0..100,000]; the elements of A are all
   * distinct; each element of array A is an integer within the range [1..(N +
   * 1)].
   * 
   * 
   */

  public int solution(int[] A) {
    Arrays.sort(A);
    int i = 0;
    for (i = 0; i < A.length; i++) {
      if (A[i] != i + 1) {
        break;
      }
    }
    return i + 1;
  }

  public static void main(String[] args) {
    var sol = new Solution();

    System.out.println(sol.solution(new int[] {1, 2, 3, 3})); // 4
    System.out.println(sol.solution(new int[] {2, 3, 4})); // 1
    System.out.println(sol.solution(new int[] {1, 1})); // 2
    System.out.println(sol.solution(new int[] {3})); // 1
    System.out.println(sol.solution(new int[] {})); // 1
  }
}
