package train.maxcounters;

import java.util.Arrays;

public class Solution {
  /*
   * 
   * You are given N counters, initially set to 0, and you have two possible
   * operations on them:
   * 
   * increase(X) − counter X is increased by 1
   * max counter − all counters are set to the maximum value of any counter.
   * 
   * A non-empty array A of M integers is given. This array represents consecutive
   * operations:
   * 
   * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X)
   * if A[K] = N + 1 then operation K is max counter.
   * 
   * For example, given integer N = 5 and array A such that: 
   * A[0] = 3 
   * A[1] = 4
   * A[2] = 4 
   * A[3] = 6 
   * A[4] = 1 
   * A[5] = 4 
   * A[6] = 4
   * 
   * the values of the counters after each consecutive operation will be: 
   * (0, 0, 1, 0, 0) 
   * (0, 0, 1, 1, 0) 
   * (0, 0, 1, 2, 0) 
   * (2, 2, 2, 2, 2) 
   * (3, 2, 2, 2, 2) 
   * (3, 2, 2, 3, 2) 
   * (3, 2, 2, 4, 2)
   * 
   * The goal is to calculate the value of every counter after all operations.
   * 
   * Write a function:
   * 
   * class Solution { public int[] solution(int N, int[] A); }
   * 
   * that, given an integer N and a non-empty array A consisting of M integers,
   * returns a sequence of integers representing the values of the counters.
   * 
   * Result array should be returned as an array of integers.
   * 
   * For example, given: 
   * A[0] = 3 
   * A[1] = 4 
   * A[2] = 4 
   * A[3] = 6 
   * A[4] = 1 
   * A[5] = 4
   * A[6] = 4
   * 
   * the function should return [3, 2, 2, 4, 2], as explained above.
   * 
   * Write an efficient algorithm for the following assumptions:
   * 
   * N and M are integers within the range [1..100,000]; 
   * each element of array A is an integer within the range [1..N + 1].
   * 
   */

  public int[] solution(int N, int[] A) {
    int[] counter = new int[N];
    int max = 0;

    for(int i = 0; i < A.length; i++){ // O(M)
      int x = A[i];

      if(1 <= x && x <= N ) {
        counter[x - 1]++;
        
        if(max < counter[x - 1]){
          max = counter[x - 1];
        }

      } else if(x == N + 1) {
        Arrays.fill(counter, max);  // O(N)
      }
    }

    return counter;
  }


  public static void main(String[] args) {
    Solution solution = new Solution();

    String answer = Arrays.toString(solution.solution(5, new int[] {3, 4, 4, 6, 1, 4, 4}));
    System.out.println(answer);

    String answer2 = Arrays.toString(solution.solution(8, new int[] {2}));
    System.out.println(answer2);

    String answer3 = Arrays.toString(solution.solution(8, new int[] {21, 2, 9}));
    System.out.println(answer3);

    String answer4 = Arrays.toString(solution.solution(8, new int[] {9, 2, 21}));
    System.out.println(answer4);
    
  }

}
