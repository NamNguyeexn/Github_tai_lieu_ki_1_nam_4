/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.serializetime;

/**
 *
 * @author monto
 */
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class SerializeTime{
    public static void main(String [] args){
        String filename = "time.ser";
        if(args.length > 0) {
            filename = args[0];
        }
        // Create an object
        PersistentTime time = new PersistentTime();
        // Serialize the object instance and save it in
        // a file.
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(time);
            out.close();
        } catch(IOException ex) {
        ex.printStackTrace();
        }
        System.out.println("Current time is saved into " + filename);
    }
}