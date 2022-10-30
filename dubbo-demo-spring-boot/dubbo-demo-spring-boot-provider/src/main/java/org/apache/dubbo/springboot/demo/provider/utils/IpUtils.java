package org.apache.dubbo.springboot.demo.provider.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IpUtils {
    public static List<String> getIp(){
        List<String> ipList = new ArrayList<>();
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress ip = addresses.nextElement();
                    ipList.add(ip.getHostAddress());
                }
            }
        }catch(Exception ignore){
        }
        return ipList;
    }
}
