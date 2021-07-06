package train.cyclicrotation;

import java.util.Arrays;

public class Solution {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 11
        int[] result = A;
        int length = result.length;
        if (length > 0) {
            for (var i = 0; i < K; i++) {
                int last = result[length - 1];
                for (int j = length - 1; j >= 0; j--) {
                    if (j > 0) {
                        result[j] = result[j - 1];
                    } else {
                        result[j] = last;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var A = new int[] { 1, 2, 3, 4, 5 };
        var K = 2;

        var sol = new Solution();
        int[] result = sol.solution(A, K);

        System.out.println(Arrays.toString(result));
    }
}
