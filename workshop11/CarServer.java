package workshop11;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarServer{

	public CarServer() {

		try {	
			CarInterface intObj = new CarImplementation();

			Registry registry = LocateRegistry.createRegistry(5000);
			registry.rebind("RegisterPlate", intObj);
			System.out.println("Car is registerd in registry");
		
		} catch (Exception e) {
		
			System.err.println("Error message: " + e);
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new CarServer();
		System.out.println("server is running");
	}
}
