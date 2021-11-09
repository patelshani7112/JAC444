package studentSwing;


import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class StudentDeserializeWithSwing extends JFrame {

	private JPanel contentPane;

	public StudentDeserializeWithSwing() {
		int i = 1;
		ArrayList<Student> studentList;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("------------ Students Information ------------");
		contentPane.add(title);

		try {
			
			FileInputStream fin = new FileInputStream("studentOutput.out");
			ObjectInputStream oIn = new ObjectInputStream(fin);

			studentList = (ArrayList<Student>)oIn.readObject();

			if(studentList != null) {
				for(Student student:studentList) {
			        JTextArea studentData = new JTextArea(student.toString());
			        studentData.setEditable(false);
			        JLabel studentTitle = new JLabel("Student " + i);

			        contentPane.add(studentTitle);
			        contentPane.add(studentData);
			        i++;
				}
			}

			oIn.close();
			fin.close();
			
		} catch (Throwable errorMsg) {
			
			System.err.println(errorMsg);
		}

		JButton genButton = new JButton("Exit");
		genButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		contentPane.add(genButton);
	}
}
