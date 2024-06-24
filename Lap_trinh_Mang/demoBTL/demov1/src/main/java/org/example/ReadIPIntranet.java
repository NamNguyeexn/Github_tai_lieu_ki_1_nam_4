package org.example;

import org.pcap4j.core.BpfProgram;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.IpPacket;
import org.pcap4j.packet.Packet;
import org.pcap4j.util.NifSelector;

public class ReadIPIntranet {
    public static void main(String[] args) throws Exception {
        // Chọn một giao diện mạng để lắng nghe
        PcapNetworkInterface nif = new NifSelector().selectNetworkInterface();

        // Mở một PcapHandle để bắt các gói tin trên giao diện đã chọn
//        int snapshotLength = 65536; // Độ dài tối đa của gói tin bạn muốn bắt
//        int readTimeout = 10; // Thời gian timeout khi đọc gói tin (milliseconds)
//

        try {
            String networkInterface = "eth0"; // Tên của card mạng bạn muốn sử dụng

            // Mở PcapHandle với chế độ promiscuous
            PcapHandle handle = Pcaps.openOffline(networkInterface, PcapHandle.TimestampPrecision.NANO);

            // Thiết lập chế độ promiscuous
            handle.setFilter("", BpfProgram.BpfCompileMode.OPTIMIZE);

            // Tiếp tục sử dụng handle để bắt gói tin mạng
            while (true) {
                Packet packet = handle.getNextPacket();
                if (packet != null && packet.contains(IpPacket.class)) {
                    IpPacket ipPacket = packet.get(IpPacket.class);
                    System.out.println("Source IP: " + ipPacket.getHeader().getSrcAddr());
                    System.out.println("Destination IP: " + ipPacket.getHeader().getDstAddr());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
