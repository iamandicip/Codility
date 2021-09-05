package train.enigma;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

  final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  final static int alphabetSize = alphabet.length();

  public static void main(String args[]) {

    String[] rotors = new String[3];

    Scanner in = new Scanner(System.in);
    String operation = in.nextLine();
    int pseudoRandomNumber = in.nextInt();
    if (in.hasNextLine()) {
      in.nextLine();
    }
    for (int i = 0; i < 3; i++) {
      String rotor = in.nextLine();
      rotors[i] = rotor;
    }
    String message = in.nextLine();

    String result = null;

    if(operation.equals("ENCODE")){
      result = encrypt(message, pseudoRandomNumber, rotors);
    } else {
      result = decrypt(message, pseudoRandomNumber, rotors);
    }

    System.out.println(result);

    // int pseudoRandomNumber = 9;
    // rotors = new String[]{"BDFHJLCPRTXVZNYEIWGAKMUSQO", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "EKMFLGDQVZNTOWYHXUSPAIBRCJ"};
    // String message = "EVERYONEISWELCOMEHEREEVERYONEISWELCOMEHERE";

    // System.err.println("Original: " + message);

    // String rotated = rotate(message, rotors);
    // System.out.println("Rotated: " + rotated);

    // String unRotated = unRotate(rotated, rotors);
    // System.err.println("Unrotated: " + unRotated);

    // String shifted = shift(message, pseudoRandomNumber);
    // System.err.println("Shifted: " + shifted);

    // String unshifted = unshift(shifted, pseudoRandomNumber);
    // System.err.println("Unshifted: " + unshifted);

    // String encrypted = encrypt(message, pseudoRandomNumber, rotors);
    // System.err.println("Encrypted: " + encrypted);

    // String decrypted = decrypt(encrypted, pseudoRandomNumber, rotors);
    // System.err.println("Decrypted: " + decrypted);
  }

  private static String encrypt(String message, int pseudoRandomNumber, String[] rotors) {
    String encrypted = shift(message, pseudoRandomNumber);
    encrypted = rotate(encrypted, rotors);
    return encrypted;
  }

  private static String decrypt(String message, int pseudoRandomNumber, String[] rotors) {
    String decrypted = unRotate(message, rotors);
    decrypted = unshift(decrypted, pseudoRandomNumber);
    return decrypted;
  }

  private static String shift(String message, int shift) {
    String shiftedMessage = null;
    StringBuilder sb = new StringBuilder();
    char[] chars = message.toCharArray();

    for(int i = 0; i < chars.length; i++) {
      int index = alphabet.indexOf(chars[i]) + i + shift;
      if(index >= alphabetSize) {
        index = index % alphabetSize;
      }
      char encoded = alphabet.charAt(index);
      sb.append(encoded);
    }

    shiftedMessage = sb.toString();

    return shiftedMessage;
  }

  private static String unshift(String message, int shift) {
    String shiftedMessage = null;
    StringBuilder sb = new StringBuilder();
    char[] chars = message.toCharArray();

    for(int i = 0; i < chars.length; i++) {
      int index = alphabet.indexOf(chars[i]) - i - shift;
      
      if(index < 0) {
        index = (alphabetSize - (Math.abs(index) % alphabetSize)) % alphabetSize;
      }

      char encoded = alphabet.charAt(index);
      sb.append(encoded);
    }

    shiftedMessage = sb.toString();

    return shiftedMessage;
  }

  private static String rotate(String message, String[] rotors) {
    String workingMessage = message;

    for(String rotor : rotors) {
      workingMessage = rotateOnce(workingMessage, rotor);
    }
    
    return workingMessage;
  }

  private static String unRotate(String message, String[] rotors) {
    Collections.reverse(Arrays.asList(rotors));
    String workingMessage = message;

    for(String rotor : rotors) {
      workingMessage = unRotateOnce(workingMessage, rotor);
    }
    
    return workingMessage;
  }

  private static String rotateOnce(String message, String rotor) {
    char[] chars = message.toCharArray();
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < chars.length; i++) {
      int index = alphabet.indexOf(chars[i]);
      sb.append(rotor.charAt(index));
    }
    message = sb.toString();
    
    return message;
  }

  private static String unRotateOnce(String message, String rotor) {
    char[] chars = message.toCharArray();
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < chars.length; i++) {
      int index = rotor.indexOf(chars[i]);
      sb.append(alphabet.charAt(index));
    }
    message = sb.toString();
    
    return message;
  }
}
