package Lession6_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
public class CalculatorImpl implements Calculator {

    @Override
    public void Caculator() {
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}