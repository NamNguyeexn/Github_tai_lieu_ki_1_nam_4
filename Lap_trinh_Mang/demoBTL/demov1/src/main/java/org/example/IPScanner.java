//package org.example;
//
//import java.net.InetAddress;
//import java.util.List;
//import org.pcap4j.core.BpfProgram.BpfCompileMode;
//import org.pcap4j.core.NotOpenException;
//import org.pcap4j.core.PcapDumper;
//import org.pcap4j.core.PcapNativeException;
//import org.pcap4j.core.PcapNetworkInterface;
//import org.pcap4j.packet.IpV4Packet;
//public class IPScanner {
//    public class IpScanner {
//
//        public static void main(String[] args) throws PcapNativeException, NotOpenException {
//
//            // Lấy danh sách các interface mạng có thể quét trên máy
//            List<PcapNetworkInterface> allDevs = PcapNetworkInterface.;
//
//            // Chọn một interface ngẫu nhiên để quét
//            PcapNetworkInterface device = allDevs.get(0);
//
//            // Tạo đối tượng PcapDumper để quét packets trên interface đó
//            PcapDumper pcapDumper = device.openLive(65536, BpfCompileMode.OPTIMIZE, 1000);
//
//            try {
//                // Vòng lặp để quét liên tục
//                while(true) {
//
//                    // Lấy một gói tin từ luồng quét
//                    PcapPacket packet = pcapDumper.getNextPacketEx();
//
//                    // Kiểm tra và hiển thị địa chỉ nguồn trong gói tin
//                    if(packet != null) {
//                        IpV4Packet ipPacket = (IpV4Packet) packet.get(IpV4Packet.class);
//                        InetAddress srcAddr = ipPacket.getHeader().getSrcAddr();
//                        System.out.println("Địa chỉ IP: " + srcAddr);
//                    }
//
//                }
//
//            } catch (PcapTimeoutException e) {
//                // Xử lý trường hợp timeout
//            } finally {
//                // Đóng kết nối
//                pcapDumper.close();
//            }
//
//        }
//
//    }
//}
