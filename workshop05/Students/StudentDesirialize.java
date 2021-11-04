package Students;
import java.io.*;
import java.util.ArrayList;

public class StudentDesirialize {
	
	@SuppressWarnings("unchecked")
	
	public static void main(String[] args) {
	
		int totalStudent = 1;
		ArrayList<Student> students;

		try {
			
			FileInputStream fIn = new FileInputStream("studentOutput.out");
			ObjectInputStream oIn = new ObjectInputStream(fIn);

			System.out.println("------------- Students Data -------------");
 
			students = (ArrayList<Student>)oIn.readObject();

			if(students != null) {
		
				for(Student student:students) {
					
					System.out.printf("Student %s%n",totalStudent++);
					System.out.printf("%s%n",student.toString());
				}
			}
			
			oIn.close();
			fIn.close();
		} 
		catch (Throwable e) {
			System.err.println(e);
		}
	}
}
