package org.apache.dubbo.springboot.demo.provider.utils;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.lionsoul.ip2region.xdb.Searcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class Ip2regionUtil {

    private static final Logger log = LoggerFactory.getLogger(Ip2regionUtil.class);

    public static String ip2region(String ip) {
        log.info("ip:{}", ip);

        String region = null;
        Searcher searcher = null;
        try {
            Resource resource = new ClassPathResource("ip2region.xdb");
            InputStream is = resource.getInputStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
                os.flush();
            }
            byte[] cBuff = os.toByteArray();
            os.close();
            is.close();
            searcher = Searcher.newWithBuffer(cBuff);
            long sTime = System.nanoTime();
            region = searcher.search(ip);
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
        } catch (Exception e) {
            System.out.printf("failed to create searcher with `%s`: %s\n", "ip2region.xdb", e);
        } finally {
            try {
                searcher.close();
            } catch (IOException ignore) {
            }
        }
        return region;
    }
}

