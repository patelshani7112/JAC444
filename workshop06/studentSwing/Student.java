package studentSwing;

import java.util.ArrayList;
import java.io.Serializable;

public class Student implements Serializable {
	
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;

	public Student() {
		stdID = 0;
		firstName = "";
		lastName = "";
		courses = new ArrayList<String>();
	}
	
	public int getStdID() {
		return stdID;
	}

	public void setStdID(String stdID) {
		int id = Integer.parseInt(stdID);
		this.stdID = id;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}

	public void setCourse(String course) {
		courses.add(course);
	}

	public ArrayList<String> getCourses(){
		return courses;
	}

	@Override
	public String toString(){
		return String.format(" StudentId : %s%n Name: %s%n Classes: %s%n", this.getStdID(),this.getName(), this.getCourses());
	}
}