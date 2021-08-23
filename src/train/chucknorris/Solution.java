package train.chucknorris;

import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
  
  public static void main(String args[]) {
    // Scanner in = new Scanner(System.in);
    // String MESSAGE = in.nextLine();

    String MESSAGE = "Message from Chuck Norris";

    StringBuilder sb = new StringBuilder();
    char previousChar = '_';

    for (char c : MESSAGE.toCharArray()) {
      // make sure the char has 7 bytes
      String binaryString = Integer.toBinaryString(c);
      while (binaryString.length() < 7) {
        binaryString = "0" + binaryString;
      }

      char[] binaryChars = binaryString.toCharArray();

      for (char b : binaryChars) {

        if (b != previousChar) {
          if (sb.length() > 0) {
            sb.append(' ');
          }
          sb.append('0');
          if (b == '0') {
            sb.append('0');
          }
          sb.append(' ');
        }

        sb.append('0');

        System.err.println(b + " -> " + sb.toString());

        previousChar = b;
      }
    }

    System.out.println(sb.toString());
  }
}
