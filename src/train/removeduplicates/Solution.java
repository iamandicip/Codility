package train.removeduplicates;

class Solution {

  /*
   * Given an integer array nums sorted in non-decreasing order, remove the
   * duplicates in-place such that each unique element appears only once. The
   * relative order of the elements should be kept the same.
   * 
   * Since it is impossible to change the length of the array in some languages,
   * you must instead have the result be placed in the first part of the array
   * nums. More formally, if there are k elements after removing the duplicates,
   * then the first k elements of nums should hold the final result. It does not
   * matter what you leave beyond the first k elements.
   * 
   * Return k after placing the final result in the first k slots of nums.
   * 
   * Do not allocate extra space for another array. You must do this by modifying
   * the input array in-place with O(1) extra memory.
   */

  public int removeDuplicates(int[] nums) {
    int i = 0;
    int counter = 0;

    for (int j = 0; j < nums.length; j++) {
      counter++;

      if (counter <= 1) {
        nums[i] = nums[j];
        i++;
      }

      if (j == nums.length - 1 || nums[j] != nums[j + 1]) {
        counter = 0;
      }
    }

    return i;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.removeDuplicates(new int[] { }));
    System.out.println(solution.removeDuplicates(new int[] { 1 }));
    System.out.println(solution.removeDuplicates(new int[] { 1, 2 }));
    System.out.println(solution.removeDuplicates(new int[] { 1, 1, 2 }));
  }
}