package org.apache.dubbo.springboot.demo.provider.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.net.InetAddress;

public class GeoLite2Utils {
    private static final Logger log = LoggerFactory.getLogger(GeoLite2Utils.class);

    public static String location(String ip) {
        try {
            Resource resource = new ClassPathResource("GeoLite2-City.mmdb");
            DatabaseReader databaseReader = new DatabaseReader.Builder(resource.getInputStream()).build();
            CityResponse cityResponse = databaseReader.city(InetAddress.getByName(ip));
            if (cityResponse != null) {
                StringBuffer stringBuffer = new StringBuffer();
                Country country = cityResponse.getCountry();
                if (country != null) {
                    stringBuffer.append("country:").append(country.getNames().get("zh-CN")).append(",");
                }
                City city = cityResponse.getCity();
                if (city != null) {
                    stringBuffer.append("city,").append(city.toJson()).append(",");
                }
                Location location = cityResponse.getLocation();
                if (location != null) {
                    stringBuffer.append("location:").append("[").append(location.getLatitude()).append(",").append(location.getLongitude()).append("]").append(",");
                }
                Subdivision subdivision = cityResponse.getMostSpecificSubdivision();
                if (subdivision != null) {
                    stringBuffer.append("subdivision,").append(subdivision.getNames().get("zh-CN")).append(",");
                }
                Traits traits = cityResponse.getTraits();
                if (traits != null) {
                    stringBuffer.append("traits,").append(traits.toJson()).append(",");
                }
                Continent continent = cityResponse.getContinent();
                if (continent != null) {
                    stringBuffer.append("continent,").append(continent.getNames().get("zh-CN")).append(",");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
                }
                return stringBuffer.toString();
            }
            else {
                return null;
            }
        } catch (Exception e) {
            log.error("GeoLite2异常", e);
            return  null;
        }
    }
}
