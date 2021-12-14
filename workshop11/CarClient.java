package workshop11;

import java.rmi.Naming;

public class CarClient {
	public static void main(String[] args) throws java.rmi.RemoteException {
		
		Car carObj = new Car("Rolls Royce", "light blue", 200); 

		System.out.println(carObj.toString());
		
		try {
			CarInterface newCarInt = (CarInterface) Naming.lookup("rmi://localhost:5000/NewCarRegistration"); 
			carObj = newCarInt.generatePlate(carObj);
			System.out.println(carObj.toString());
	
		}catch(Throwable e){
			System.out.println(e);
		}
	}
}
