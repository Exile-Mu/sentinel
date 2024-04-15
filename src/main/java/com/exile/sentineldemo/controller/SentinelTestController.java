package com.exile.sentineldemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.exile.sentineldemo.exception.TestBlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sentinel")
public class SentinelTestController {

    @GetMapping("/test")
    @SentinelResource(value = "test", blockHandler = "test", blockHandlerClass = TestBlockException.class)
    public String test() throws InterruptedException {
        log.info("执行test...");
        Thread.sleep(200);
        return "test";
    }

    @GetMapping("/test2")
    public String test2() throws InterruptedException {
        log.info("执行test2...");
        Thread.sleep(200);
        return "test2";
    }
}
