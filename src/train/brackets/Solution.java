package train.brackets;

import java.util.Stack;

public class Solution { 
  /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
  */

  public static boolean isValid(String s) {
    Stack<String> openChars = new Stack<>();
    
    for(char c: s.toCharArray()) {
      String current = String.valueOf(c);
      
      if(!openChars.isEmpty()) {
        String openChar = openChars.peek();
        if(isClosing(openChar, current)) {
          openChars.pop();
        } else {
          openChars.push(current);
        }
      } else {
        openChars.push(current);
      }
    }

    return openChars.isEmpty();
  }

  private static boolean isClosing(String openChar, String closingChar) {
    return openChar.equals("{") && closingChar.equals("}")
    || openChar.equals("[") && closingChar.equals("]")
    || openChar.equals("(") && closingChar.equals(")");
  }
 
  public static void main(String[] args) {
    System.err.println(isValid("()")); // true
    System.err.println(isValid("()[]{}")); // true
    System.err.println(isValid("(]")); // false
    System.err.println(isValid("([)]")); // false
    System.err.println(isValid("{[]}")); // true
  }
}