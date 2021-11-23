package workshop0809;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProcess {

	// task1
	public static void task1(List<Student> studentList) {
		
		System.out.println("\nTask 1\n");
		System.out.println("Complete Student list:");
		
		studentList.forEach(System.out::println);
	}
	
	// task2
	public static void task2(List<Student> studentList) {
		
		System.out.println("\n\nTask 2\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");		
		
		studentList.stream().filter(student -> student.getGrade() >= 50) 
        .sorted(Comparator.comparing(Student::getGrade)) 
        .forEach(System.out::println);
	}

	// task3
	public static void task3(List<Student> studentList) {
	
		System.out.println("\n\nTask 3\n");
		System.out.println("First Student who got 50.0-100.0:");
		
		System.out.println(StudentProcess.GradeR(studentList, 50, 100).get(0));
	}
	
	// task4
	public static void task4(List<Student> studentList) {
		
		System.out.println("\n\nTask 4\n");
		System.out.println("Students in ascending order by last name then first:");

		studentList.stream()
    	.sorted(Comparator.comparing(Student::getFirstName))
    	.sorted(Comparator.comparing(Student::getLastName)) 
    	.forEach(System.out::println);
		
		System.out.println("\nStudents in descending order by last name then first:");

		studentList.stream()
    	.sorted(Comparator.comparing(Student::getFirstName).reversed()) 
    	.sorted(Comparator.comparing(Student::getLastName).reversed()) 
    	.forEach(System.out::println);
	}
	
	// task5
	public static void task5(List<Student> studentList) {
		
		System.out.println("\n\nTask 5\n");
		System.out.println("Unique Student last names:");
				
		studentList.stream().map(Student::getName).distinct().sorted();
		// display student based on unique last name
		StudentProcess.uniqueLastName(studentList).forEach(System.out::println);
	}

	public static List<String> uniqueLastName(List<Student> sList) {
		return sList.stream().map(stu -> stu.getName().split(" ")).map(stdName -> stdName[1]).distinct()
				.collect(Collectors.toList());
	}
	
	public static List<Student> GradeR(List<Student> stdList, double lowGrade, double highGrade) {
		return stdList.stream().filter(s -> s.getGrade() >= lowGrade && s.getGrade() <= highGrade)
				.collect(Collectors.toList());
	}
	

}

