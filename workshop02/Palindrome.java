package ws02;

public class Palindrome {
	 
	  public static void main (String[] args) {
		  if(isPalindrome(args[0])) {
			  System.out.println(args[0] + " is a Polidrome");
	        } else {
	        	System.out.println(args[0] + " is not a Polidrome");
	        }
	    }
	  
	  static boolean isPalindrome(String str) {
		  boolean result = true;
		  int strLength = str.length();
		  Stack newStack = new Stack(strLength);
		  
		  
		  //
		  for(int i=0; i < strLength; ++i) {
			  newStack.pushArray(str.charAt(i));
		  }
		  
		  for(int i=0; i < strLength && result; ++i) {
			 result =  str.charAt(i) == newStack.popArray() ? true : false;
		  }
		  
		  return result;
	  }
}
