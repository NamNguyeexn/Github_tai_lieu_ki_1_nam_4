package Lession6_RMI;

import Lession6_RMI.Calculator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, ClassNotFoundException {
        Calculator cal = (Calculator) Naming.lookup("rmi://10.20.80.46/cal13102023");
        System.out.println(cal.add(454, 100));

//        try{
//            System.out.println("Finding Object … ");
//// tim doi tuong tu xa theo ten dang ky
//            Calculator cal= (Calculator)Naming.lookup ("rmi://localhost/cal");
//// trieu goi phuong thuc tu xa
//            System.out.println(cal.add(10,20));
//        } catch(Exception e) { System.out.println(e); }
//    }
    }
}
