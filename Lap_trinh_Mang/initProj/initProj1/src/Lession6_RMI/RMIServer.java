package Lession6_RMI;

import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    public static void main(String[] args) throws AlreadyBoundException {
        try{


            //tao doi tuong CalculatorImpl
            CalculatorImpl cal= new CalculatorImpl();
            System.out.println("Exporting Calculator ! ");
//thong bao su hien dien của cal la doi tuong co kha nang remote cho JVM
            UnicastRemoteObject.exportObject (cal); // ???
//dang ky doi tuong voi trinh quan ly rmi
            Naming.bind("rmi://localhost/cal13102023", cal);
            System.out.println("Register Calculator!");
        } catch(Exception e)
        { System.out.println(e); }
    }
}
