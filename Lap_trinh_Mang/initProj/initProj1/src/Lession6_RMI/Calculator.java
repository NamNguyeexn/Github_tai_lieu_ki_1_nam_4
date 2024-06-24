package Lession6_RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
 public interface Calculator extends Remote
 {
     public void Caculator();
     public int add(int a,int b) throws RemoteException;
 }