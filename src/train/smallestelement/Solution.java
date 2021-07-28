package train.smallestelement;

import java.util.*;
import java.util.stream.*;

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
   * 
   */

  public int solution(int[] A) {
    int missing = 0;

    Set<Integer> unique = Arrays.stream(A).boxed().collect(Collectors.toSet()); // O(1)
    Integer[] nums = unique.toArray(new Integer[unique.size()]); // O(n * log(n))
    Arrays.sort(nums);

    int min = nums[0];
    int max = nums[nums.length - 1];

    if(min > 1 || min < 0) { // all bigger than 1 or all negative
      missing = 1;
    
    } else if(max - min == nums.length - 1){ // consecutive
      missing = max + 1;
    
    } else {
      for(int i = 0; i < nums.length - 1; i++) { 
        missing = nums[i] + 1;
        if(i < nums.length - 1 && nums[i + 1] - nums[i] > 1) { // search for gaps 
          break;
        }
      }
    }

    return missing;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[] {1, 3, 6, 4, 1, 2}));
    System.out.println(solution.solution(new int[] {1, 3, 2}));
    System.out.println(solution.solution(new int[] {-99999999, 999999999}));
    System.out.println(solution.solution(new int[] {0, 0}));
    System.out.println(solution.solution(new int[] {10000}));
  }

}
