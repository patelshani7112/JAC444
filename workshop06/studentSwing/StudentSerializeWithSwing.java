package studentSwing;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
public class StudentSerializeWithSwing extends JFrame {

	private JPanel contentPane;
	private JTextField stdIDField, firstNameField, lastNameField, courseField;
	private JLabel JLabel1, JLabel2;

	int stdIdNum = -1;
	private Student student;
	private ArrayList<Student> students;
	private JTextArea ListOfCourses;

	public StudentSerializeWithSwing() {
		
		student = new Student();
		students = new ArrayList<Student>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel stdIDLabel = new JLabel("Student ID : ");
		stdIDLabel.setBounds(50, 15, 90, 15);
		contentPane.add(stdIDLabel);

		JLabel fNameLabel = new JLabel("FIrst Name : ");
		fNameLabel.setBounds(45, 55, 85, 15);
		contentPane.add(fNameLabel);

		JLabel lNameLabel = new JLabel("Last Name : ");
		lNameLabel.setBounds(45, 90, 75, 15);
		contentPane.add(lNameLabel);

		stdIDField = new JTextField();
		stdIDField.setBounds(140, 10, 130, 25);
		contentPane.add(stdIDField);
		stdIDField.setColumns(10);
		JLabel1 = new JLabel("Invalid value!");
		JLabel1.setForeground(Color.RED);
		JLabel1.setBounds(280, 15, 95, 15);
		contentPane.add(JLabel1);
		JLabel1.setVisible(false);

		firstNameField = new JTextField();
		firstNameField.setBounds(140, 50, 130, 25);
		contentPane.add(firstNameField);
		firstNameField.setColumns(10);

		lastNameField = new JTextField();
		lastNameField.setBounds(140, 85, 130, 25);
		contentPane.add(lastNameField);
		lastNameField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Classes : ");
		lblNewLabel_4.setBounds(65, 135, 60, 15);
		contentPane.add(lblNewLabel_4);

		JLabel2 = new JLabel("Empty!");
		JLabel2.setForeground(Color.RED);
		JLabel2.setBounds(285, 135, 90, 15);
		contentPane.add(JLabel2);
		JLabel2.setVisible(false);

		courseField = new JTextField();
		courseField.setBounds(140, 130, 130, 25);
		contentPane.add(courseField);
		courseField.setColumns(10);
		CourseHandler handler1 = new CourseHandler();
		courseField.addActionListener(handler1);

		JButton saveButton = new JButton("Save");
		onSaveHandler onSaveHandler = new onSaveHandler();
		saveButton.addActionListener(onSaveHandler);
		saveButton.setBounds(45, 220, 118, 30);
		contentPane.add(saveButton);

		JButton submitButton = new JButton("Submit");
		onSubmitHandler onSubmitHandler = new onSubmitHandler();
		submitButton.addActionListener(onSubmitHandler);
		submitButton.setBounds(235, 220, 118, 30);
		contentPane.add(submitButton);

		ListOfCourses = new JTextArea("");
		ListOfCourses.setBackground(SystemColor.window);
		ListOfCourses.setBounds(141, 164, 253, 43);
		ListOfCourses.setVisible(false);
		contentPane.add(ListOfCourses);

	}

	public boolean writeStudentInfo(){
		boolean isTrue = true;

		try (FileOutputStream fIn = new FileOutputStream("studentOutput.out");
				ObjectOutputStream out = new ObjectOutputStream(fIn);) {
			
			out.writeObject(students);

			out.close();
			fIn.close();
			
		} catch (FileNotFoundException errorMsg) {
			System.err.println(errorMsg);
			isTrue = false;
			
		}catch (IOException errorMsg) {
			System.err.println(errorMsg);
			isTrue = false;
			
		} catch (Throwable errorMsg) {
			System.err.println(errorMsg);
			isTrue = false;
		}
		
		return isTrue;
	}


	public void clear() {
		stdIDField.setText("");;
		firstNameField.setText("");
		lastNameField.setText("");
		courseField.setText("");
		ListOfCourses.setText("");

		if(JLabel1.isVisible()) {
			JLabel1.setVisible(false);
		}

		if(JLabel2.isVisible()) {
			JLabel2.setVisible(false);
		}

		student = new Student();
	}


	private class CourseHandler implements ActionListener{
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
				try {
					String courseData = courseField.getText();
					student.setCourse(courseData);
					
					if(!student.getCourses().isEmpty()) {
						ListOfCourses.setText(student.getCourses().toString());
						ListOfCourses.setVisible(true);
					}
					
					courseField.setText("");
					if(JLabel2.isVisible()) {
						JLabel2.setVisible(false);
					}

				}catch (Throwable error) {
					JLabel2.setVisible(true);
				}
	      }
	   }

	   private class onSaveHandler implements ActionListener
	   {
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
	  		String stdId = stdIDField.getText();
			try{
				stdIdNum = Integer.parseInt(stdId);
				if(JLabel1.isVisible()) {
					JLabel1.setVisible(false);
				}

				student.setStdID(stdId);
				student.setFirstName(firstNameField.getText());
				student.setLastName(lastNameField.getText());
				students.add(student);
				clear();
			}catch(Throwable error) {
				JLabel1.setVisible(true);
			}
	      }
	   }

	   private class onSubmitHandler implements ActionListener
	   {
	      @Override
	      public void actionPerformed(ActionEvent event) {
	    	  
			try{
				
				boolean isTrue = writeStudentInfo();
				if(!isTrue) {
					System.out.println("failed to Submit");
				}

				 System.exit(0);
			}catch(Throwable error) {
				JLabel1.setVisible(true);
			}
	      }
	   }


}
