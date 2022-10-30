package org.apache.dubbo.springboot.demo.provider.controller;
import org.apache.dubbo.springboot.demo.provider.config.Result;
import org.apache.dubbo.springboot.demo.provider.utils.GeoLite2Utils;
import org.apache.dubbo.springboot.demo.provider.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    private static final Logger log = LoggerFactory.getLogger(ProviderController.class);

    @PostMapping(value = "/ip")
    public Object ip() {
        log.info("请求获取ip地址信息了");
        List<String> ip = IpUtils.getIp();
        List<String> result = new ArrayList<>();
        if (!CollectionUtils.isEmpty(ip)) {
            ip.stream().forEach(i -> {
                String s = GeoLite2Utils.location(i);
                if (!StringUtils.isEmpty(s)) {
                    result.add(s);
                }
            });
        }
        if (!CollectionUtils.isEmpty(result)) {
            return Result.success("请求成功", result);
        }
        return Result.success("请求成功", ip);
    }
}
