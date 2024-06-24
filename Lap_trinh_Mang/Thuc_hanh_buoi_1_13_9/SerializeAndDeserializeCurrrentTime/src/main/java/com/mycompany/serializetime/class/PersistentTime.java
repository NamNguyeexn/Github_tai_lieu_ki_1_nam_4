/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author monto
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
public class PersistentTime implements Serializable{
    private Date time;
    public PersistentTime() {
        time = Calendar.getInstance().getTime();
    }
    public Date getTime() {
        return time;
    }
}
