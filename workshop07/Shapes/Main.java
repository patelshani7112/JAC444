package Shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {

		Shape[] shapes;
		int Count = 0;
		
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.printf("------->Task 1 ... <-------%n");

		try {
			Path path = Paths.get("shapes.txt");
			Count = (int)Files.lines(path).count();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		shapes = new Shape[(int) Count];
		runTask1("shapes.txt",shapes);
	}

	private static void runTask1(String fileName, Shape[] shapes) {
		
		String line;
		int numOfShapes = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			
			while((line = br.readLine()) != null) {
				String[] token = line.split(",");
				
				try {
					Shape shape  = getShape(token);

					if(shape != null ) {
						shapes[numOfShapes] = shape;
						numOfShapes++;
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} 
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.printf("%n%s shapes were created: %n", numOfShapes);
		displayResult(shapes);
	}

	
	private static double parseDouble(String s) {
		return Double.parseDouble(s);
	}

	// shape class validation
	private static Shape getShape(String[] token) throws CircleException, SquareException, ParallelogramException, TriangleException {
		
		Shape shape = null;

		switch(token[0]) {
		
		case "Square":
			if(token.length == 2) {
				shape= new Square(parseDouble(token[1]));
			}
			break;
			
		case "Circle":
			if(token.length == 2) {
				shape = new Circle(parseDouble(token[1]));
			}
			break;
			
		case "Rectangle":
			if(token.length == 3) {
				shape = new Rectangle(parseDouble(token[1]),parseDouble(token[2]));
			}
			break;
			
		case "Parallelogram":
			if(token.length == 3) {
				shape = new Parallelogram(parseDouble(token[1]),parseDouble(token[2]));
			}
			break;
			
		case "Triangle":
			if(token.length == 4) {
				shape = new Triangle(parseDouble(token[1]),parseDouble(token[2]), parseDouble(token[3]));
			}
			break;
			
		default:
			break;
		} 
		return shape;
	}

	// task1 display	 
	private static void displayResult(Shape[] shapes) {
		for(Shape shape: shapes) {
			if(shape != null) {
				System.out.printf("%s perimeter = %g %n%n", shape.toString(), shape.getPerimeter());
			}
		}
	}
}


