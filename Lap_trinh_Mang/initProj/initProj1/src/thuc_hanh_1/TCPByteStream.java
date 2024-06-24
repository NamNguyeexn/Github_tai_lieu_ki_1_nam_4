package thuc_hanh_1;

import java.io.*;
import java.net.Socket;

public class TCPByteStream {
    public static long sum(String s) {
        long sumi = 0;
        for (int i = 0; i < s.length(); i++) {
            String mid = "";
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                mid += String.valueOf(s.charAt(i));
                if (s.charAt(i) == '|') {
                    sumi += Long.parseLong(mid);
                }
            }
        }
        return sumi;
    }
        public static void main (String[]args) throws IOException {
            String serverAddress = "10.20.85.177";
            int serverPort = 806;

            Socket socket = new Socket(serverAddress, serverPort);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter send = new PrintWriter(socket.getOutputStream(), true);
            send.println("B20DCCN454;700");

            BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = inServer.readLine();
//            s.split("\\|");
            System.out.println(sum(s));
            send.println(sum(s));


            outputStream.close();
            send.close();
        }
    }

