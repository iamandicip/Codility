package train.chucknorris;

public class Solution {

/*

Binary with 0 and 1 is good, but binary with only 0, or almost, is even better! Originally, this is a concept designed by Chuck Norris to send so called unary messages.

Write a program that takes an incoming message as input and displays as output the message encoded using Chuck Norris’ method.
  Rules

Here is the encoding principle:

    The input message consists of ASCII characters (7-bit)
    The encoded output message consists of blocks of 0
    A block is separated from another block by a space
    Two consecutive blocks are used to produce a series of same value bits (only 1 or 0 values):
    - First block: it is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0
    - Second block: the number of 0 in this block is the number of bits in the series

  Example

Let’s take a simple example with a message which consists of only one character: Capital C. C in binary is represented as 1000011, so with Chuck Norris’ technique this gives:

    0 0 (the first series consists of only a single 1)
    00 0000 (the second series consists of four 0)
    0 00 (the third consists of two 1)

So C is coded as: 0 0 00 0000 0 00
 

Second example, we want to encode the message CC (i.e. the 14 bits 10000111000011) :

    0 0 (one single 1)
    00 0000 (four 0)
    0 000 (three 1)
    00 0000 (four 0)
    0 00 (two 1)

So CC is coded as: 0 0 00 0000 0 000 00 0000 0 00

*/
  
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
