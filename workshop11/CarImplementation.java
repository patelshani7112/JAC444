package workshop11;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarImplementation  extends UnicastRemoteObject implements CarInterface {

	public CarImplementation() throws RemoteException {
        super();
    }

    public Car generatePlate(Car car) throws RemoteException {
        car.setPlate(Integer.toString(car.hashCode()));
        return car;
    }
}