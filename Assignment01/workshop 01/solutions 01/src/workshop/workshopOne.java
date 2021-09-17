package workshop;
import java.lang.Math;
import java.text.NumberFormat;

public class workshopOne {
	
 public static void main(String[] args) {
	 	 
	 int rows =8, count =1, noOfSpaces =rows-1;


	 // count the number of rows
	 for (int i=1 ; i<=rows; i++) {
		 
		 int k=0;
		 
		 // control the required space 
		 for(int j=1; j <= noOfSpaces; j++) {
			 System.out.print("    ");
		 }
		 
		 for(int j=1; j<=count; j++) {
			 
			 if(j<=i) {
			// increase by 1 in k  
				 k =k+1;
			 } else {
			// decrease by 1 in k	 
				 k = k-1;
			 }
			 
			 // convert the number into string
			 String stringNumber = String.format("% 4d" ,((int) Math.pow(2, k-1)));
			
			 // print the string 
			 System.out.print(stringNumber + "");
			 }
		 
		 System.out.println();
		 count=count+2;
		 noOfSpaces= noOfSpaces-1;
	 }
 }
}
