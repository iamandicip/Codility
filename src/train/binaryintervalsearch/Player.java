package train.binaryintervalsearch;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int W = in.nextInt(); // width of the building.
    int H = in.nextInt(); // height of the building.
    int N = in.nextInt(); // maximum number of turns before game over.
    int X0 = in.nextInt();
    int Y0 = in.nextInt();

    int x = X0;
    int y = Y0;

    // variables to store the horizontal and vertical intervals
    int[] xInt = { 0, W - 1 };
    int[] yInt = { 0, H - 1 };

    // game loop
    while (true) {
      // the direction of the bombs from batman's current location (U, UR, R, DR, D,
      // DL, L or UL)
      String bombDir = in.next();

      // Write an action using System.out.println()
      // To debug: System.err.println("Debug messages...");
      for (char direction : bombDir.toCharArray()) {
        switch (direction) {
          case 'U': {
            yInt[1] = y;
            y -= halfIntervalRoundUp(yInt);
            break;
          }
          case 'D': {
            yInt[0] = y;
            y += halfIntervalRoundUp(yInt);
            break;
          }
          case 'R': {
            xInt[0] = x;
            x += halfIntervalRoundUp(xInt);
            break;
          }
          case 'L': {
            xInt[1] = x;
            x -= halfIntervalRoundUp(xInt);
            break;
          }
        }
      }

      // the location of the next window Batman should jump to.
      System.out.println(x + " " + y);
    }
  }

  private static int halfIntervalRoundUp(int[] interval) {
    return (int) Math.ceil((double) (interval[1] - interval[0]) / 2);
  }
}
