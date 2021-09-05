package train.bfspath;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    static class Node {
        Integer y;
        Integer x;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object other) {
            if (this == other){
                return true;
            } else if(other == null || !(other instanceof Node)) {
                return false;
            } else {
                Node otherNode = (Node) other;
                return this.x == otherNode.x && this.y == otherNode.y;
            }
        }

        public int hashCode() {
            return x.hashCode() * y.hashCode();
        }

        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt(); // number of rows.
        int C = in.nextInt(); // number of columns.
        int A = in.nextInt(); // number of rounds between the time the alarm countdown is activated and the time the alarm goes off.

        Stack<Node> visited = new Stack<>();
        Stack<Node> excluded = new Stack<>();

        boolean found = false;
        Node previousNode = null;

        // game loop
        while (true) {
            int KR = in.nextInt(); // row where Kirk is located.
            int KC = in.nextInt(); // column where Kirk is located.

            char DU = '?', DD = '?', DR = '?', DL = '?', CP = '?';

            Node currentNode = new Node(KC, KR);
            Node nextNode = null;
            String direction = null;

            for (int i = 0; i < R; i++) {
                String ROW = in.next(); // C of the characters in '#.TC?' (i.e. one line of the ASCII maze).

                if(i == KR - 1) {
                    DU = ROW.charAt(KC);
                } else if (i == KR + 1) {
                    DD = ROW.charAt(KC);
                } else if (i == KR) {
                    DL = ROW.charAt(KC - 1);
                    DR = ROW.charAt(KC + 1);
                    CP = ROW.charAt(KC);
                    if(CP == 'C') {
                        found = true;
                    }
                }
            }

            if(!found) {

                int optionsCount = optionsCount(DU, DD, DR, DL);

                if (DU == 'C') {
                    nextNode = new Node(KC, KR - 1);
                    System.err.println("UP");
                } else if (DD == 'C') {
                    nextNode = new Node(KC, KR + 1);
                    System.err.println("DOWN");
                } else if (DR == 'C') {
                    nextNode = new Node(KC + 1, KR);
                    System.err.println("RIGHT");
                } else if (DL == 'C') {
                    nextNode = new Node(KC - 1, KR);
                    System.err.println("LEFT");
                } else {

                    if (DR == '.') {
                        System.err.println("Checking RIGHT");

                        Node potentialNode = new Node(KC + 1, KR);
                        nextNode = validatePotentialNode(potentialNode, visited, excluded);
                    }

                    if (DD == '.' && nextNode == null)  {
                        System.err.println("Checking DOWN");

                        Node potentialNode = new Node(KC, KR + 1);
                        nextNode = validatePotentialNode(potentialNode, visited, excluded);
                    }

                    if (DL == '.' && nextNode == null) {
                        System.err.println("Checking LEFT");

                        Node potentialNode = new Node(KC - 1, KR);
                        nextNode = validatePotentialNode(potentialNode, visited, excluded);
                    }

                    if (DU == '.' && nextNode == null) {
                        System.err.println("Checking UP");

                        Node potentialNode = new Node(KC, KR - 1);
                        nextNode = validatePotentialNode(potentialNode, visited, excluded);
                    }

                    if (nextNode == null) {
                        System.err.println("PREVIOUS");

                        excluded.push(currentNode);

                        nextNode = visited.pop();
                    }
                }

                if(!excluded.contains(currentNode)){
                  System.err.println("Saving: " + currentNode);
                  visited.push(currentNode);
              } else if(visited.contains(currentNode)) {
                  if(optionsCount == 1) {
                      System.err.println("Forgetting: " + previousNode);
                      visited.remove(previousNode);
                  } else {
                      System.err.println("Excluding: " + previousNode);
                      excluded.push(previousNode);
                  }
              }

            } else {
                nextNode = visited.pop();
                System.err.println("Retrieving: " + nextNode);
            }

            direction = getDirectionFromNodes(currentNode, nextNode);

            previousNode = currentNode;

            System.out.println(direction); // Kirk's next move (UP DOWN LEFT or RIGHT).
        }
    }

    public static int optionsCount(char DU, char DD, char DR, char DL) {
        int result = 0;
        if(DU == '.') result++;
        if(DD == '.') result++;
        if(DR == '.') result++;
        if(DL == '.') result++;
        return result;
    }

    public static Node validatePotentialNode(Node potentialNode, List<Node> visited, List<Node> excluded) {
        Node nextNode = null;
        boolean potentialValid = !visited.contains(potentialNode) && !excluded.contains(potentialNode);

        if(potentialValid) {
            nextNode = potentialNode;
        }

        return nextNode;
    }

    public static String getDirectionFromNodes(Node node1, Node node2) {
        String direction = null;
        if(node1.x > node2.x) {
            direction = "LEFT";
        } else if (node1.x < node2.x) {
            direction = "RIGHT";
        } else if (node1.y > node2.y) {
            direction = "UP";
        } else if (node1.y < node2.y) {
            direction = "DOWN";
        }

        return direction;
    }
}
