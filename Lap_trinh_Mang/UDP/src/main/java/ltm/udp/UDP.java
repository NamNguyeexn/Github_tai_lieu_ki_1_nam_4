/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ltm.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author monto
 */
public class UDP {
    public static int port = 2208;
    public static String address = "192.168.1.8";
    private void send(DatagramSocket socket, String request) throws UnknownHostException, IOException {
        InetAddress ia = InetAddress.getByName(address);
        byte[] bytes = request.getBytes();
        socket.send(new DatagramPacket(bytes, bytes.length, ia, port));
    }
    private String receive(DatagramSocket socket) throws IOException {
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        socket.receive(dp);
        return new String(dp.getData());
    }
    //Client UDP
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket ds = new DatagramSocket();
        
        String msv = ";B20DCCN454;932";
        byte[] bs = msv.getBytes();
        InetAddress ia = InetAddress.getByName(address);
        DatagramPacket dp1 = new DatagramPacket(bs, bs.length, ia, port);
        ds.send(dp1);
        
        byte[] bs1 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(bs1,bs1.length);
        ds.receive(dp2);
        String[] inpString = new String (dp2.getData()).split("\\;");
        String[] str = inpString[1].split("\\ ");
        String res = "";
           for (var b : str) {
            StringBuilder word = new StringBuilder();
            word.append(b.toUpperCase().charAt(0));
            for (int i = 1; i < b.length(); i++) {
                if (b.charAt(i) >= 'A' && b.charAt(i) <='Z') {
                    word.append(String.valueOf(b.charAt(0)).toLowerCase());
                }
                else word.append(b.charAt(i));
            }
            res += word + " ";
        }
        byte[] bs3 = res.getBytes();
        DatagramPacket dp3 = new DatagramPacket(bs3, bs3.length, ia, port);
        ds.send(dp3);
    }
}
