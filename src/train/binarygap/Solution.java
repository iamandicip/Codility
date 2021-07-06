package train.binarygap;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        System.out.print("Input number: ");

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Solution solution = new Solution();
        int binaryGap = solution.solution(N);

        System.out.printf("\nBinary gap for %d is: %d", N, binaryGap);
        in.close();
    }

    public int solution(int N) {
        int longestGap = 0;
        int currentGap = 0;

        String binaryString = Integer.toBinaryString(N);
        System.out.printf("Binary value for %d is: %s", N, binaryString);

        for (char c : binaryString.toCharArray()) {
            if (c == '0') {
                currentGap++;
            } else {
                if (currentGap > longestGap) {
                    longestGap = currentGap;
                }
                currentGap = 0;
            }
        }
        return longestGap;
    }
}
