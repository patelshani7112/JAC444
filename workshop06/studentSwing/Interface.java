package studentSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame{
	
	    private final JLabel printQuestion; 
		private final JButton dataInputButton; 
		private final JButton readDataButton;
	
		public Interface() { 
			
			setLayout(new FlowLayout());
			
			dataInputButton = new JButton("Enter Data");
			readDataButton = new JButton("Show Data");
		
			printQuestion = new JLabel("Choose to Enter Data or Show Data?");
			
			add(printQuestion);
			add(dataInputButton);
			add(readDataButton);
			
			printQuestion.setVerticalTextPosition(SwingConstants.CENTER);
			
			ButtonHandler DataDataReadHandler = new ButtonHandler();
			ButtonHandler DataWriteHandler = new ButtonHandler();
			readDataButton.addActionListener(DataDataReadHandler);
			dataInputButton.addActionListener(DataWriteHandler);
		}
		
		private class ButtonHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(e.getActionCommand().equals("Enter Data")) {  
				
				StudentSerializeWithSwing textField = new StudentSerializeWithSwing();
			      textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      textField.setSize(400, 300); 
			      textField.setVisible(true); 	      		
			
			} else if(e.getActionCommand().equals("Show Data")) {  
				
				StudentDeserializeWithSwing textField = new StudentDeserializeWithSwing();
			      textField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      textField.setSize(400, 300); 
			      textField.setVisible(true); 
			     }	
			}
		}	
		 public static void main(String[] args)
		   { 
			 Interface frame = new Interface(); 
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      frame.setSize(280, 120); 
		      frame.setVisible(true); 
		     
		    }
		
}