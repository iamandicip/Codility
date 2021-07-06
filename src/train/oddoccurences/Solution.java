package train.oddoccurences;

import java.util.Arrays;

public class Solution {

    public int solution(int[] A) {
        Arrays.sort(A);
        int result = A[0];

        for(var i = 0; i < A.length; i++) {
            if(i < A.length - 1 && A[i] == A[i+1]){
                i++;
            } else {
                result = A[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var A = new int[]{5, 1, 2, 6, 1, 4, 2, 3, 3, 5, 6};
        var B = new int[]{5, 1, 2, 6, 1, 7, 2, 3, 3, 5, 6};
        var C = new int[]{5, 1, 3, 6, 1, 0, 3, 3, 3, 5, 6};

        var sol = new Solution();

        System.out.println(sol.solution(A));
        System.out.println(sol.solution(B));
        System.out.println(sol.solution(C));
    }
}
