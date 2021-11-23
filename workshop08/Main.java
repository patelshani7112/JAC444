package workshop0809;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Student[] students = { 
				 new Student("Jack", "Smith", 50.0, "IT"),
				 new Student("Aaron", "Johnson", 76.0, "IT"),
				 new Student("Maaria", "White", 35.8, "Business"),
				 new Student("John", "White", 47.0, "Media"),
				 new Student("Laney", "White", 62.0, "IT"),
				 new Student("Jack", "Jones", 32.9, "Business"),
				 new Student("Wesley", "Jones", 42.89, "Media")};
		
		List<Student> studentsList = new ArrayList(Arrays.asList(students));
		
		StudentProcess.task1(studentsList);
		StudentProcess.task2(studentsList);
		StudentProcess.task3(studentsList);
		StudentProcess.task4(studentsList);
		StudentProcess.task5(studentsList);

		
	}
}