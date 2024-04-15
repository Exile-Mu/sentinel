package com.exile.sentineldemo.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBlockException {

    public static String test(BlockException e) {
        log.warn("Blocked by Sentinel, block by function {{test}}: {}", e.getRule());
        return "exception test";
    }
}
