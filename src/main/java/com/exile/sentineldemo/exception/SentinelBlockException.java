package com.exile.sentineldemo.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class SentinelBlockException implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, BlockException e) throws Exception {
        log.warn("Blocked by Sentinel, block by function {{handle}}: {}", e.getRule());
        response.setContentType("application/json");
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        response.getWriter().print("exception test2");
    }
}
