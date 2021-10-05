package ws02;

public class Stack {
	
	private int currentPos;
	char[] polArray;
	

	/* constructor to initialize size to the array */
	
	public Stack(int size) {
		polArray = new char[size];
	}
	
	/* Add(push) and single CHAR to the array*/
	
	public void pushArray(char c) {
		polArray[currentPos++] = c;
	}
	
	/* remove the single CHAR from the array*/
	
	public char popArray() {
		return polArray[--currentPos];
	}
}
