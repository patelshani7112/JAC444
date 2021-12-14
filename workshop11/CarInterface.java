package workshop11;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.RemoteException;
import java.rmi.RemoteException;

public interface CarInterface extends Remote {
    Car generatePlate(Car car) throws RemoteException;
}