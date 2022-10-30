package org.apache.dubbo.springboot.demo.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.springboot.demo.DemoService;
import org.apache.dubbo.springboot.demo.provider.utils.GeoLite2Utils;
import org.apache.dubbo.springboot.demo.provider.utils.Ip2regionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@DubboService
public class DemoServiceImpl implements DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        log.info("Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name;
    }

    @Override
    public Object demo(String ip) {
        Map<String, Object> map = new HashMap<>();
        map.put("source", ip);
        map.put("ip2region", Ip2regionUtil.ip2region(ip));
        map.put("GeoLite2", GeoLite2Utils.location(ip));
        return map;
    }
}
