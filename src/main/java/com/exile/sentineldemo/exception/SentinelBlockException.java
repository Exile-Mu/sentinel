package com.exile.sentineldemo.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class SentinelBlockException implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, String s, BlockException e) throws Exception {
        log.warn("Blocked by Sentinel, block by function {{handle}}: {}", e.getRule());
        response.setContentType("application/json");
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        response.getWriter().print("exception test2");
    }
}
