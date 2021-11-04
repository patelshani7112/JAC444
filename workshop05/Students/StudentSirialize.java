package Students;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentSirialize {
	
	private static Scanner scanner;
	private static Student student;

	public static void main(String[] args) {
		
		scanner  = new Scanner(System.in);

		boolean isSuccessed = addInfo();
		if(!isSuccessed) {
			System.out.println("Sirialize Failed.");
		}
	}
	 
	public static boolean addInfo() {
		
		boolean isSuccessed = true;
		char c;
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			do {
				student =  new Student();
				setStudentId();
				setName();
				setCourse();

				do {
					System.out.printf("Do you want to add another student? (Y or N) : ");
					c = scanner.nextLine().trim().charAt(0);
					
					if(c != 'Y' && c != 'N') {
						System.out.println("Invalid Character please enter again.");
					}
					
				}while(c != 'Y' && c != 'N');
				students.add(student);
				
			}while(c == 'Y');

		} catch (Throwable e) {
			System.err.println(e);
			isSuccessed = false;
		}

		if(isSuccessed) {
			isSuccessed = writeStudentInfo(students);
		}
		return isSuccessed;
	}

		public static void setStudentId() {
			
		int id = -1;
		String stdID;

		System.out.println("Please enter student information.");

		do {
			System.out.print("Enter student number: ");
		
			try {
			
				stdID = scanner.nextLine().trim();
				student.setStdID(stdID);
				id = Integer.parseInt(stdID);
				
			}catch(Exception e) {	
				System.out.println(e.getMessage());
			}
			
		}while(id == -1);
	}

	public static void setName() {
		String firstName = "", lastName = "";

		do {
			System.out.print("Please Enter firstName: ");
			firstName = scanner.nextLine();
			
			try {
				student.setFirstName(firstName);
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(firstName.trim().isEmpty() || firstName.isEmpty());

		do {
			
			System.out.printf("Please Enter lastName: ");
			lastName = scanner.nextLine();
			
			try {
				student.setLastName(lastName);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}		
		}while(lastName.trim().isEmpty() || lastName.isEmpty());
	}

	public static void setCourse() {
		String courseName;
		
		do {
			System.out.printf("Please enter your course information OR 'q' For Quit ");
			courseName = scanner.nextLine();
			
			if(!courseName.equals("q")) {
				try{
					student.setCourse(courseName);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} while(!courseName.equals("q"));

	}

	public static boolean writeStudentInfo(ArrayList<Student> students){
		boolean isSuccessed = true;

		try (FileOutputStream fOut = new FileOutputStream("studentOutput.out");
				ObjectOutputStream out = new ObjectOutputStream(fOut);) {
			
			out.writeObject(students);

			out.close();
			fOut.close();
			
		} catch (FileNotFoundException e) {
			System.err.println(e);
			isSuccessed = false;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccessed;
	}
}